package com.david.evalartTest.service.subsidiary_service;

import com.david.evalartTest.entity.subsidiary.SubsidiaryEntity;
import com.david.evalartTest.repository.SubsidiaryRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SubsidiaryServiceImpl implements SubsidiaryService {
    private final SubsidiaryRepository subsidiaryRepository;

    public SubsidiaryServiceImpl(SubsidiaryRepository subsidiaryRepository) {
        this.subsidiaryRepository = subsidiaryRepository;
    }

    @Override
    public Mono<SubsidiaryEntity> getById(long id) {
        return subsidiaryRepository.findById(id) ;
    }

    @Override
    public Mono<SubsidiaryEntity> createSubsidiary(String name) {
        return subsidiaryRepository.save(new SubsidiaryEntity(0,name));
    }

    @Override
    public Flux<SubsidiaryEntity> getAllSubs() {
        return subsidiaryRepository.findAll();
    }
}
