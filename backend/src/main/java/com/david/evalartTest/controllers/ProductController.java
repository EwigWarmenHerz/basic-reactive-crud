package com.david.evalartTest.controllers;

import com.david.evalartTest.entity.product.ProductEntity;
import com.david.evalartTest.entity.stock.MostStockedProductDto;
import com.david.evalartTest.entity.stock.Stock;
import com.david.evalartTest.service.product_service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired

    @GetMapping("/get_all")
    public Flux<ProductEntity> getAllProducts(){
        return productService.getAll();
    }

    @GetMapping("/get")
    public Mono<ProductEntity> getSingleByID(@RequestParam long id){
        return productService.getById(id);
    }

    @GetMapping("/most_stocked")
    public Mono<List<MostStockedProductDto>> getMostStokedProducts(@RequestParam long subsidiaryId){
        return productService.listMostStockedProductPerBranchOfSubsidiary(subsidiaryId);
    }

    @PostMapping("/add_product")
    public Mono<ProductEntity> createProduct(@RequestParam String name){
        return productService.createProduct(name);
    }

    @PutMapping("/edit_product")
    public Mono<ProductEntity> editProduct(@RequestBody ProductEntity productEntity ){
        return productService.updateProduct(productEntity);
    }

    @PostMapping("/assign_product_to_branch")
    public Mono<Stock> assignProduct(@RequestParam long productId, @RequestParam long branchId, long quantity){
        var newStock = new Stock(0, productId, branchId, quantity);
        return productService.CreateStockForBranch(newStock);
    }

    @PutMapping("/modify_stock")
    public Mono<Stock> editStock(@RequestBody Stock stock){
        System.out.println(stock);
        return productService.editStock(stock);
    }

    @DeleteMapping("/remove_stock_from_branch")
    public Mono<String> removeStock(@RequestParam long stockId){
        return productService.deleteStockForBranch(stockId);
    }

    @DeleteMapping("/delete_product")
    public Mono<String> deleteProduct(@RequestParam long id){
        return productService.deleteProduct(id);
    }

}
