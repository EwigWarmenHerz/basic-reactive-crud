package com.david.evalartTest.controllers;

import com.david.evalartTest.entity.product.ProductEntity;
import com.david.evalartTest.entity.subsidiary.SubsidiaryEntity;
import com.david.evalartTest.service.subsidiary_service.SubsidiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/subsidiary")
public class SubsidiaryController {

    @Autowired
    SubsidiaryService subsiduaryService;


    @GetMapping("/gel_all")
    public Flux<SubsidiaryEntity> getAll(){
        return subsiduaryService.getAllSubs();
    }

    @GetMapping("/get")
    public Mono<SubsidiaryEntity> getSingleByID(@RequestParam long id){
        return subsiduaryService.getById(id);
    }

    @PostMapping("/add")
    public Mono<SubsidiaryEntity> create(@RequestParam String name){
        return subsiduaryService.createSubsidiary(name);
    }

    @PutMapping("/edit")
    public Mono<SubsidiaryEntity> edit(@RequestParam String name){
        return subsiduaryService.createSubsidiary(name);
    }

    /*@DeleteMapping("/delete")
    public Mono<String> delete(@RequestParam long id){
        return subsiduaryService;
    }*/




}
