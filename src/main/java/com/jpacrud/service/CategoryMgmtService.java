package com.jpacrud.service;

import com.jpacrud.domain.Category;
import com.jpacrud.dto.CategoryDto;
import com.jpacrud.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CategoryMgmtService {

    /**
     *  관리자(admin) 권한예정
     */

    private final CategoryRepository categoryRepository;


    /**
     * 카테고리 생성
     * @param categoryDto
     * @return
     */
    @Transactional
    public Long createBoard(CategoryDto categoryDto){

         Category category = new Category();

        category.create(categoryDto);

        return categoryRepository.save(category).getCategoryId();
    }

    /**
     * 카테고리 수정
     */
    @Transactional
    public Long updateCategory(CategoryDto categoryDto){
        Category category = categoryRepository.findById(categoryDto.getCategoryId()).orElse(null);



        categoryDto.setCategory(category);


        category.create(categoryDto);

        return categoryRepository.save(category).getCategoryId();
    }


    /**
     * 카테고리 삭제
     */
    @Transactional
    public void deleteBoard(CategoryDto categoryDto){

        categoryRepository.deleteById(categoryDto.getCategoryId());
    }

}
