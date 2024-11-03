package com.david.evalartTest.controllers;

import com.david.evalartTest.entity.product.ProductEntity;
import com.david.evalartTest.entity.subsidiary_branch.SubsidiaryBranchEntity;
import com.david.evalartTest.service.subsidiary_branch_service.SubsidiaryBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("branch")
public class SubsidiaryBranchController {

    @Autowired
    SubsidiaryBranchService subsidiaryBranchService;


    @GetMapping("/get_all")
    public Flux<SubsidiaryBranchEntity> getAll(){
        return subsidiaryBranchService.getAll();
    }

    /*@GetMapping("/get")
    public Mono<SubsidiaryBranchEntity> getSingleByID(@RequestParam long id){
        return subsidiaryBranchService ;
    }*/

    @PostMapping("/add")
    public Mono<SubsidiaryBranchEntity> create(@RequestParam String name, @RequestParam long subsidiaryId){
        return subsidiaryBranchService.createSubsidiaryBranch(name, subsidiaryId);
    }

    @PostMapping("/edit")
    public Mono<SubsidiaryBranchEntity> editBranchName(@RequestBody SubsidiaryBranchEntity subsidiaryBranchEntity){
        return subsidiaryBranchService.editBranch(subsidiaryBranchEntity);
    }

    @PutMapping("/assign_to_subsidiary")
    public Mono<SubsidiaryBranchEntity> editProduct(@RequestParam long branchId, @RequestParam long subsidiaryId ){
        return subsidiaryBranchService.assignBranch2Subsidiary(branchId, subsidiaryId) ;
    }

    /*@DeleteMapping("/delete")
    public Mono<String> deleteProduct(@RequestParam long id){
        return  ;
    }*/

    @GetMapping("/get_branches")
    public Flux<SubsidiaryBranchEntity> getSubsidiaryBranchList(@RequestParam long subsidiaryId){
        return subsidiaryBranchService.getAllBySubsidiaryId(subsidiaryId);
    }
}
