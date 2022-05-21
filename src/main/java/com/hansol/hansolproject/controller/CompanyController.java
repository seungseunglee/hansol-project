package com.hansol.hansolproject.controller;

import com.hansol.hansolproject.domain.Company;
import com.hansol.hansolproject.service.CompanyService;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/companys")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    @ApiOperation(value = "모든 회사 조회")
    public ResponseEntity<?> getAllCompanys() {

        final List<Company> companys = companyService.getAllCompanys();

        return ResponseEntity.ok(companys);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "id로 회사 조회")
    public ResponseEntity<?> getCompanyById(@PathVariable Long id) {

        final Company company = companyService.getCompanyById(id);

        return ResponseEntity.ok(company);
    }

    @PostMapping
    @ApiOperation(value = "회사 생성")
    public ResponseEntity<?> createCompany(@RequestBody CompanyDto request) {

        final Long id = companyService.createCompany(request.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "회사 수정")
    public ResponseEntity<?> updateCompany(@PathVariable Long id, @RequestBody CompanyDto request) {

        companyService.updateCompany(id, request.getName());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "회사 삭제")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id) {

        companyService.deleteCompany(id);

        return ResponseEntity.noContent().build();
    }

    @Getter
    static class CompanyDto {
        @NonNull
        private String name;
    }

}
