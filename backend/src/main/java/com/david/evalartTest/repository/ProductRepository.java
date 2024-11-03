package com.david.evalartTest.repository;

import com.david.evalartTest.entity.product.ProductEntity;
import com.david.evalartTest.service.product_service.ProductService;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends ReactiveCrudRepository<ProductEntity, Long> {
}
