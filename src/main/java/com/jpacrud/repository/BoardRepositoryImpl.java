package com.jpacrud.repository;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.QBoard;
import com.jpacrud.domain.QCategory;
import com.jpacrud.dto.BoardDto;
import com.jpacrud.dto.QBoardDto;
import com.jpacrud.dto.request.BoardListRequestDto;
import com.jpacrud.dto.response.BoardListResponseDto;
import com.jpacrud.dto.response.QBoardListResponseDto;
import com.jpacrud.repository.custom.CustomBoardRepository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
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

    /**
     *     복잡한 페이징
     *     데이터 조회 쿼리와, 전체 카운트 쿼리를 분리
     *     데이터 내용과 전체 카운트를 별도로 조회하는 방법
     */
    @Override
    public Page<BoardListResponseDto> searchPageComplex(BoardListRequestDto requestDto, Pageable pageable) {
        List<BoardListResponseDto> content = jpaQueryFactory
                .select(new QBoardListResponseDto(
                        QCategory.category.categoryId,
                        QCategory.category.categoryName,
                        QBoard.board.boardTitle,
                        QBoard.board.createDate,
                        QBoard.board.modifyDate
                ))
                .from(QBoard.board)
                .innerJoin(QBoard.board.category, QCategory.category)
                .where(
                        categoryNameEq(requestDto.getCategoryName())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch(); //콘텐츠쿼리 두번 날림

            long total = jpaQueryFactory
                    .select(QBoard.board)
                    .from(QBoard.board)
                    .join(QBoard.board.category, QCategory.category)
                    .where(
                            categoryNameEq(requestDto.getCategoryName())
                    ).fetchCount(); //데이터가 몇천건 있을때 사용

        return new PageImpl<>(content, pageable, total);
    }

    /**
     * count 쿼리가 생략 가능한 경우 생략해서 처리
     * 페이지 시작이면서 컨텐츠 사이즈보다 작을때
     * 마지막 페이지 일 때(offset + 컨텐츠 사이즈를 더해서 전체 사이즈 구함)
     */
    @Override
    public Page<BoardListResponseDto> searchPageComplex_v2(BoardListRequestDto requestDto, Pageable pageable) {
        List<BoardListResponseDto> content = jpaQueryFactory
                .select(new QBoardListResponseDto(
                        QCategory.category.categoryId,
                        QCategory.category.categoryName,
                        QBoard.board.boardTitle,
                        QBoard.board.createDate,
                        QBoard.board.modifyDate
                ))
                .from(QBoard.board)
                .innerJoin(QBoard.board.category, QCategory.category)
                .where(
                        categoryNameEq(requestDto.getCategoryName())
                )
                .orderBy(QBoard.board.createDate.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch(); //콘텐츠쿼리 두번 날림

        JPAQuery<Board> countQuery = jpaQueryFactory
                .select(QBoard.board)
                .from(QBoard.board)
                .innerJoin(QBoard.board.category, QCategory.category)
                .where(
                        categoryNameEq(requestDto.getCategoryName())
                );


        return PageableExecutionUtils.getPage(content, pageable, () -> countQuery.fetchCount());
    }


//    //게시판 삭제 queryDSL
//    @Override
//    public Long deleteBoard(BoardDto boardDto) {
//        return jpaQueryFactory
//                .select(new QBoardDto(
//                        QCategory.category.categoryId.as("cateogryId"),
//                        QBoard.board.boardTitle.as("boardTitle"),
//                        QBoard.board.createDate.as("createDate"),
//                        QBoard.board.modifyDate.as("modifyDate"))
//
//
//
//                .from(QBoard.board)
//                .innerJoin(QBoard.board.category, QCategory.category)
//
//                .where(categoryIdEq(requestDto.getCategoryName()))
//                .fetchOne();
//    }

    private BooleanExpression categoryNameEq(String categoryName) {
        return StringUtils.hasText(categoryName) ? QCategory.category.categoryName.eq(categoryName) : null;
    } //공백, null 체크


}

