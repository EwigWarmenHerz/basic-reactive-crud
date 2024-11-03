package com.david.evalartTest.service.subsidiary_service;

import com.david.evalartTest.entity.subsidiary.SubsidiaryEntity;
import com.david.evalartTest.service.subsidiary_branch_service.SubsidiaryBranchService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubsidiaryService {
    Mono<SubsidiaryEntity> getById(long id);
    Mono<SubsidiaryEntity> createSubsidiary(String name);
    Flux<SubsidiaryEntity> getAllSubs();
}
