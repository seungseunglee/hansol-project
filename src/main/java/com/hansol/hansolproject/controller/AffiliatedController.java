package com.hansol.hansolproject.controller;

import com.hansol.hansolproject.domain.Affiliated;
import com.hansol.hansolproject.domain.Company;
import com.hansol.hansolproject.domain.Employee;
import com.hansol.hansolproject.service.AffiliatedService;
import com.hansol.hansolproject.service.CompanyService;
import com.hansol.hansolproject.service.EmployeeService;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/api/affiliateds")
public class AffiliatedController {

    private final AffiliatedService affiliatedService;
    private final EmployeeService employeeService;
    private final CompanyService companyService;

    @Autowired
    public AffiliatedController(AffiliatedService affiliatedService, EmployeeService employeeService, CompanyService companyService) {
        this.affiliatedService = affiliatedService;
        this.employeeService = employeeService;
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAffiliateds() {

        final List<Affiliated> affiliateds = affiliatedService.getAllAffiliateds();

        return ResponseEntity.ok(affiliateds);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAffiliatedById(@PathVariable Long id) {

        final Affiliated affiliated = affiliatedService.getAffiliatedById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "affiliated #" + id + " is not founded"));

        return ResponseEntity.ok(affiliated);
    }

    @PostMapping
    public ResponseEntity<?> createAffiliated(@RequestBody AffiliatedDto request) {

        employeeService.getEmployeeById(request.getEmployeeId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "employee #" + request.getEmployeeId() + " is not founded"));
        companyService.getCompanyById(request.getCompanyId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "company #" + request.getCompanyId() + " is not founded"));

        final Long id = affiliatedService.createAffiliated(request.getEmployeeId(), request.getCompanyId());

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAffiliated(@PathVariable Long id, @RequestBody AffiliatedDto request) {

        employeeService.getEmployeeById(request.getEmployeeId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "employee #" + request.getEmployeeId() + " is not founded"));
        companyService.getCompanyById(request.getCompanyId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "company #" + request.getCompanyId() + " is not founded"));

        final Affiliated affiliated = affiliatedService.getAffiliatedById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "affiliated #" + id + " is not founded"));

        affiliatedService.updateAffiliated(affiliated, request.getEmployeeId(), request.getCompanyId());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAffiliated(@PathVariable Long id) {

        affiliatedService.getAffiliatedById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "affiliated #" + id + " is not founded"));

        affiliatedService.deleteAffiliated(id);

        return ResponseEntity.noContent().build();
    }

    @Getter
    static class AffiliatedDto {

        @NonNull
        private Long employeeId;
        @NonNull
        private Long companyId;
    }

}
