package com.jpacrud.controller;

import com.jpacrud.dto.BoardDto;
import com.jpacrud.dto.CategoryDto;
import com.jpacrud.service.CategoryMgmtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "카테고리 관리 API", tags = "카테고리 관리 API")
@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/v2/api")
public class CategoryMgmtController {

    private final CategoryMgmtService categoryMgmtService;



    @ApiOperation(value = "카테고리 생성", notes = "카테고리를 생성합니다.")
    @PostMapping("/createCategory")
    public ResponseEntity<Long> createBoard (@RequestBody CategoryDto categoryDto)  {

        return ResponseEntity.ok(categoryMgmtService.createCategory(categoryDto));
    }





}
