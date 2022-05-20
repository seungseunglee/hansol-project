package com.hansol.hansolproject.controller;

import com.hansol.hansolproject.domain.Affiliated;
import com.hansol.hansolproject.service.AffiliatedService;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/affiliateds")
public class AffiliatedController {

    private final AffiliatedService affiliatedService;

    @Autowired
    public AffiliatedController(AffiliatedService affiliatedService) {
        this.affiliatedService = affiliatedService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAffiliateds() {

        final List<Affiliated> affiliateds = affiliatedService.getAllAffiliateds();

        return ResponseEntity.ok(affiliateds);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAffiliatedById(@PathVariable Long id) {

        final Affiliated affiliated = affiliatedService.getAffiliatedById(id);

        return ResponseEntity.ok(affiliated);
    }

    @PostMapping
    public ResponseEntity<?> createAffiliated(@RequestBody AffiliatedDto request) {

        final Long id = affiliatedService.createAffiliated(request.getEmployeeId(), request.getCompanyId());

        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAffiliated(@PathVariable Long id, @RequestBody AffiliatedDto request) {

        affiliatedService.updateAffiliated(id, request.getEmployeeId(), request.getCompanyId());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAffiliated(@PathVariable Long id) {

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
