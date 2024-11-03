package com.david.evalartTest.service.product_service;

import com.david.evalartTest.entity.product.ProductEntity;
import com.david.evalartTest.entity.stock.MostStockedProductDto;
import com.david.evalartTest.entity.stock.Stock;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ProductService {

    Flux<ProductEntity> getAll();
    Mono<ProductEntity> getById(long id);
    Mono<ProductEntity> createProduct(String name);
    Mono<ProductEntity> updateProduct(ProductEntity productEntity);
    Mono<String> deleteProduct(long id);

    Mono<Stock> CreateStockForBranch(Stock stock);
    Mono<String> deleteStockForBranch(long id);
    Mono<Stock> editStock(Stock stock);
    Mono<List<MostStockedProductDto>>listMostStockedProductPerBranchOfSubsidiary(long subsidiaryId);

}
