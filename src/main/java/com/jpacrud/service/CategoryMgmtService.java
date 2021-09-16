package com.jpacrud.service;

import com.jpacrud.domain.Category;
import com.jpacrud.domain.Member;
import com.jpacrud.dto.CategoryDto;
import com.jpacrud.repository.CategoryRepository;
import com.jpacrud.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.jpacrud.enums.StatusEnums.UserRole.CATEGORY_ADMIN;

@RequiredArgsConstructor
@Service
public class CategoryMgmtService {

    private final CategoryRepository categoryRepository;
    private final MemberRepository memberRepository;


    /**
     * 카테고리 생성
     */
    @Transactional
    public Long createCategory(CategoryDto categoryDto){

        Member member = memberRepository.findByMemberId(categoryDto.getMemberId());

        categoryDto.setMember(member);


        Category category = new Category();
        category.createCategory(categoryDto);


        return categoryRepository.save(category).getCategoryId();


    }



}
