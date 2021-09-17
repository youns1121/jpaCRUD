package com.jpacrud.domain;

import com.jpacrud.domain.common.BaseEntity;
import com.jpacrud.dto.CategoryDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
@Entity
public class Category extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", columnDefinition = "BIGINT unsigned comment '카테고리 아이디'")
    private Long categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_comment")
    private String categoryComment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "admin_seq")
    private Member member;

    @OneToMany(mappedBy = "category")
    private List<Subscribe> subscribeList = new ArrayList<>();

//    @OneToMany(mappedBy = "category")
//    private List<Board> boardList = new ArrayList<>();



    /**
     * 카테고리 생성
     */

    @Builder
    public void createCategory(CategoryDto categoryDto){

        this.categoryName = categoryDto.getCategoryName();
        this.categoryComment = categoryDto.getCategoryComment();
        this.member = categoryDto.getMember();
    }







}
