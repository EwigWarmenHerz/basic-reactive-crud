package com.david.evalartTest.repository;

import com.david.evalartTest.entity.subsidiary.SubsidiaryEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubsidiaryRepository extends ReactiveCrudRepository<SubsidiaryEntity, Long> {
}
