package com.hansol.hansolproject.controller;

import com.hansol.hansolproject.domain.Global;
import com.hansol.hansolproject.service.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class GlobalController {

    private final GlobalService globalService;

    @Autowired
    public GlobalController(GlobalService globalService) {
        this.globalService = globalService;
    }

    @GetMapping
    @ApiOperation(value = "모든 전체 필드 조회")
    public ResponseEntity<?> getAll() {

        final List<Global> globals = globalService.getAll();

        return ResponseEntity.ok(globals);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "사번으로 전체 필드 조회")
    public ResponseEntity<?> getByEmployeeId(@PathVariable Long id) {

        final Global global = globalService.getByEmployeeId(id);

        return ResponseEntity.ok(global);
    }

    @PostMapping
    @ApiOperation(value = "전체 필드 생성")
    public ResponseEntity<?> createGlobal(@RequestBody Global request) {

        globalService.createGlobal(request.getWorkCode(), request.getWorkName(), request.getCompany(), request.getEmpName(), request.getPosition(), request.getTask(), request.getTelephone());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "전체 필드 수정")
    public ResponseEntity<?> updateGlobal(@PathVariable Long id, @RequestBody Global request) {

        globalService.updateGlobal(id, request.getWorkCode(), request.getWorkName(), request.getCompany(), request.getEmpName(), request.getPosition(), request.getTask(), request.getTelephone());

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "전체 필드 삭제")
    public ResponseEntity<?> deleteGlobal(@PathVariable Long id) {

        globalService.deleteGlobal(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/uploadExcel", consumes = {"multipart/form-data"})
    @ApiOperation(value = "엑셀 파일 업로드")
    public ResponseEntity<?> readExcel(@RequestPart("file") MultipartFile file) throws IOException {
        List<Global> dataList = new ArrayList<>();

        String extension = FilenameUtils.getExtension(file.getOriginalFilename());

        if (!extension.equals("xlsx") && !extension.equals("xls")) {
            throw new IOException("엑셀파일만 업로드 해주세요.");
        }

        Workbook workbook;

        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else {
            workbook = new HSSFWorkbook(file.getInputStream());
        }

        Sheet worksheet = workbook.getSheetAt(0);

        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
            Row row = worksheet.getRow(i);

            Global data = Global.builder()
                    .workCode(row.getCell(0).getStringCellValue())
                    .workName(row.getCell(1).getStringCellValue())
                    .company(row.getCell(2).getStringCellValue())
                    .empName(row.getCell(3).getStringCellValue())
                    .position(row.getCell(4).getStringCellValue())
                    .task(row.getCell(5).getStringCellValue())
                    .telephone(row.getCell(6).getStringCellValue()).build();

            dataList.add(data);
        }

        globalService.createGlobalByExcel(dataList);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
