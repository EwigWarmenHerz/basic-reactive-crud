package com.david.evalartTest.service.product_service;

import com.david.evalartTest.entity.product.ProductEntity;
import com.david.evalartTest.entity.stock.MostStockedProductDto;
import com.david.evalartTest.entity.stock.Stock;
import com.david.evalartTest.repository.ProductRepository;
import com.david.evalartTest.repository.StockRepository;
import com.david.evalartTest.repository.SubsidiaryRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final StockRepository stockRepository;
    private final DatabaseClient databaseClient;
    private final SubsidiaryRepository subsidiaryRepository;

    public ProductServiceImpl(ProductRepository productRepository, StockRepository stockRepository, DatabaseClient databaseClient, SubsidiaryRepository subsidiaryRepository) {
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
        this.databaseClient = databaseClient;
        this.subsidiaryRepository = subsidiaryRepository;
    }

    @Override
    public Flux<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Mono<ProductEntity> getById(long id) {
        return productRepository.findById(id)
                .switchIfEmpty(Mono.just(new ProductEntity()));
    }

    @Override
    public Mono<ProductEntity> createProduct(String name) {
        return productRepository.save(new ProductEntity(0, name));
    }

    @Override
    public Mono<ProductEntity> updateProduct(ProductEntity productEntity) {
        return productRepository.findById(productEntity.getId())
                .flatMap(product -> {
                    product.setName(productEntity.getName());
                    return productRepository.save(product);
                });
    }

    @Override
    public Mono<String> deleteProduct(long id) {
        return productRepository.findById(id)
                .flatMap(_ -> productRepository.deleteById(id).thenReturn("Product with id: " + id + " successfully deleted"))
                .switchIfEmpty(Mono.just("Product do not exist"));
    }

    @Override
    public Mono<Stock> CreateStockForBranch(Stock stock) {
        return stockRepository.findByProductIdAndSubsidiaryBranchId(stock.getProductId(),stock.getSubsidiaryBranchId())
                .flatMap(existingStock -> {
                    existingStock.setStock(existingStock.getStock() + stock.getStock());
                    return stockRepository.save(existingStock);
                })
                .switchIfEmpty(stockRepository.save(stock));
    }

    @Override
    public Mono<String> deleteStockForBranch(long id) {
        return stockRepository.findById(id)
                .flatMap(_ -> stockRepository.deleteById(id).thenReturn("Stock product removed from branch"))
                .switchIfEmpty(Mono.just("The stock does not exist"));
    }

    @Override
    public Mono<Stock> editStock(Stock stock) {
        return stockRepository.findById(stock.getId())
                .flatMap(_ -> stockRepository.save(stock))
                .switchIfEmpty(Mono.error(new DataIntegrityViolationException("The stock does not exist")));
    }

    @Override
    public Mono<List<MostStockedProductDto>>listMostStockedProductPerBranchOfSubsidiary(long subsidiaryId) {

        var query = "SELECT p.name AS pn, sb.name AS sbn, s.stock AS stock " +
                "From stock s " +
                "INNER JOIN product p ON s.product_id = p.id " +
                "INNER JOIN subsidiary_branch sb ON s.subsidiary_branch_id = sb.id " +
                "WHERE sb.subsidiary_id = :subsidiaryId " +
                "AND s.stock = (SELECT MAX(stock) FROM stock s2 WHERE s2.subsidiary_branch_id = s.subsidiary_branch_id) ";
        return subsidiaryRepository.findById(subsidiaryId)
                .flatMap(subsidiaryEntity -> databaseClient.sql(query)
                        .bind("subsidiaryId",subsidiaryId)
                        .map((row, rowMetadata) -> new MostStockedProductDto(
                                row.get("pn", String.class),
                                subsidiaryEntity.getName(),
                                row.get("sbn", String.class),
                                row.get("stock", Long.class)

                        )).all().collectList());
    }
}
