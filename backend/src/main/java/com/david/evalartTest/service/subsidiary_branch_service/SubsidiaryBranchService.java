package com.david.evalartTest.service.subsidiary_branch_service;

import com.david.evalartTest.entity.subsidiary_branch.SubsidiaryBranchEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubsidiaryBranchService {

    Flux<SubsidiaryBranchEntity> getAll();
    Flux<SubsidiaryBranchEntity> getAllBySubsidiaryId(long id);
    Mono<SubsidiaryBranchEntity> createSubsidiaryBranch(String name, long subsidiaryId);
    Mono<SubsidiaryBranchEntity> assignBranch2Subsidiary(long branchId, long subsidiaryId);
    Mono<SubsidiaryBranchEntity> editBranch(SubsidiaryBranchEntity subsidiaryBranchEntity);

}
