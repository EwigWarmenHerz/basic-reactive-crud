package com.david.evalartTest.service.subsidiary_branch_service;

import com.david.evalartTest.entity.subsidiary_branch.SubsidiaryBranchEntity;
import com.david.evalartTest.repository.SubsidiaryBranchRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SubsidiaryBranchServiceImpl implements SubsidiaryBranchService{
    private final SubsidiaryBranchRepository subsidiaryBranchRepository;

    public SubsidiaryBranchServiceImpl(SubsidiaryBranchRepository subsidiaryBranchRepository) {
        this.subsidiaryBranchRepository = subsidiaryBranchRepository;
    }

    @Override
    public Flux<SubsidiaryBranchEntity> getAll() {
        return subsidiaryBranchRepository.findAll();
    }

    @Override
    public Flux<SubsidiaryBranchEntity> getAllBySubsidiaryId(long id) {
        return subsidiaryBranchRepository.findAllBySubsidiaryId(id);
    }

    @Override
    public Mono<SubsidiaryBranchEntity> createSubsidiaryBranch(String name, long subsidiaryId) {
        return subsidiaryBranchRepository.save(new SubsidiaryBranchEntity(
                0,
                name,
                subsidiaryId
        ));
    }

    public Mono<SubsidiaryBranchEntity> assignBranch2Subsidiary(long branchId, long subsidiaryId){
        return subsidiaryBranchRepository.findById(branchId)
                .flatMap(branch  -> {
                    branch.setSubsidiaryId(subsidiaryId);
                    return subsidiaryBranchRepository.save(branch);
                })
                .switchIfEmpty(Mono.error(new DataIntegrityViolationException("Branch does not exist!")));
    }

    @Override
    public Mono<SubsidiaryBranchEntity> editBranch(SubsidiaryBranchEntity subsidiaryBranchEntity) {
        return subsidiaryBranchRepository.findById(subsidiaryBranchEntity.getId())
                .flatMap(s -> {
                    s.setName(subsidiaryBranchEntity.getName());
                    return subsidiaryBranchRepository.save(s);
                });
    }
}
