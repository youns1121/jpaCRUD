package com.jpacrud.controller;

import com.jpacrud.dto.CategoryDto;
import com.jpacrud.service.CategoryMgmtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "카테고리 관리 API", tags = "카테고리 관리 API")
@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/v2/api")
public class CategoryMgmtApiController {



    private final CategoryMgmtService categoryMgmtService;




    @ApiOperation(value = "카테고리 생성", notes = "카테고리을 생성합니다.")
    @PostMapping("/createCategory")
    public ResponseEntity<Long> createBoard (@RequestBody CategoryDto categoryDto){

        return ResponseEntity.ok(categoryMgmtService.createBoard(categoryDto));
    }

    @ApiOperation(value = "카테고리 수정", notes = "카테고리를 수정합니다.")
    @PostMapping("/updateCategory")
    public ResponseEntity<Long> updateBoard (@RequestBody CategoryDto categoryDto){

        return ResponseEntity.ok(categoryMgmtService.updateCategory(categoryDto));
    }

    @ApiOperation(value = "카테고리 삭제", notes = "카테고리를 삭제 합니다.")
    @DeleteMapping("/deleteCategory/{categoryId}")
    public void deleteCategory (@RequestBody CategoryDto categoryDto){

        categoryMgmtService.deleteBoard(categoryDto);
    }









}
