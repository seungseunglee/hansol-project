package com.hansol.hansolproject.controller;

import com.hansol.hansolproject.domain.Company;
import com.hansol.hansolproject.service.CompanyService;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public ResponseEntity<?> getAllCompanys() {

        final List<Company> companys = companyService.getAllCompanys();

        return ResponseEntity.ok(companys);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCompanyById(@PathVariable Long id) {

        final Company company = companyService.getCompanyById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " not founded"));

        return ResponseEntity.ok(company);
    }

    @PostMapping
    public ResponseEntity<?> createCompany(@RequestBody CompanyDto request) {

        final Long id = companyService.createCompany(request.getName());

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCompany(@PathVariable Long id, @RequestBody CompanyDto request) {

        final Company company = companyService.getCompanyById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " not founded"));

        companyService.updateCompany(company, request.getName());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long id) {

        companyService.getCompanyById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, id + " not founded"));

        companyService.deleteCompany(id);

        return ResponseEntity.noContent().build();
    }

    @Getter
    static class CompanyDto {
        @NonNull
        private String name;
    }

}
