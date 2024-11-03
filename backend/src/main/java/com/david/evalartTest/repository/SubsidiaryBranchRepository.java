package com.david.evalartTest.repository;

import com.david.evalartTest.entity.subsidiary_branch.SubsidiaryBranchEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Repository
public interface SubsidiaryBranchRepository extends ReactiveCrudRepository<SubsidiaryBranchEntity, Long> {
    Flux<SubsidiaryBranchEntity> findAllBySubsidiaryId(long id);



}
