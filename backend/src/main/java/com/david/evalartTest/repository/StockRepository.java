package com.david.evalartTest.repository;

import com.david.evalartTest.entity.stock.Stock;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface StockRepository extends ReactiveCrudRepository<Stock, Long> {
    Mono<Boolean> existsByProductIdAndSubsidiaryBranchId(long productId, long subsidiaryBranchId);
    Mono<Stock> findByProductIdAndSubsidiaryBranchId(long productId, long subsidiaryBranchId);

}
