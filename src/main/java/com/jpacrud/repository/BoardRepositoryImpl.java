package com.jpacrud.repository;

import com.jpacrud.domain.QBoard;
import com.jpacrud.domain.QCategory;
import com.jpacrud.dto.request.BoardListRequestDto;
import com.jpacrud.dto.response.BoardListResponseDto;
import com.jpacrud.dto.response.QBoardListResponseDto;
import com.jpacrud.repository.custom.CustomBoardRepository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class BoardRepositoryImpl implements CustomBoardRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public BoardRepositoryImpl(EntityManager em){
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }




    @Override
    public List<BoardListResponseDto> searchSimpleList(BoardListRequestDto requestDto) {
        return jpaQueryFactory
                .select(new QBoardListResponseDto(
                        QCategory.category.categoryId.as("cateogryId"),
                        QCategory.category.categoryName.as("categoryName"),
                        QBoard.board.boardTitle.as("boardTitle"),
                        QBoard.board.createDate.as("createDate"),
                        QBoard.board.modifyDate.as("modifyDate")
                ))
                .from(QBoard.board)
                .innerJoin(QBoard.board.category, QCategory.category)

                .where(categoryNameEq(requestDto.getCategoryName()))
                .fetch();
    }

    @Override
    public Page<BoardListResponseDto> searchPageList(BoardListRequestDto requestDto, Pageable pageable) {

        QueryResults<BoardListResponseDto> results = jpaQueryFactory
                .select(new QBoardListResponseDto(
                        QCategory.category.categoryId,
                        QCategory.category.categoryName,
                        QBoard.board.boardTitle,
                        QBoard.board.createDate,
                        QBoard.board.modifyDate
                ))
                .from(QBoard.board)
                .innerJoin(QBoard.board.category, QCategory.category)

                .where(categoryNameEq(requestDto.getCategoryName()))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

            List<BoardListResponseDto> content = results.getResults();
            Long total = results.getTotal();
        return new PageImpl<>(content, pageable, total);
    }

    private BooleanExpression categoryNameEq(String categoryName) {
        return StringUtils.hasText(categoryName) ? QCategory.category.categoryName.eq(categoryName) : null;
    } //공백, null 체크


}

