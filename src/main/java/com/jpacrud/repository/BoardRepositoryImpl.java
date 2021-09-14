package com.jpacrud.repository;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.QBoard;


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
                        QBoard.board.boardTitle.as("boardTitle"),
                        QBoard.board.createDate.as("createDate"),
                        QBoard.board.modifyDate.as("modifyDate")
                ))
                .from(QBoard.board)
                .fetch();
    }

    /**
     * Querydsl이 제공하는 fetchResults() 를 사용하면 내용과 전체 카운트를 한번에 조회할 수 있다.(실제
     * 쿼리는 2번 호출)
     * fetchResult() 는 카운트 쿼리 실행시 필요없는 order by 는 제거한다
     */

    @Override
    public Page<BoardListResponseDto> searchPageList(BoardListRequestDto requestDto, Pageable pageable) {

        QueryResults<BoardListResponseDto> results = jpaQueryFactory
                .select(new QBoardListResponseDto(
                        QBoard.board.boardTitle,
                        QBoard.board.createDate,
                        QBoard.board.modifyDate

                ))
                .from(QBoard.board)

                .where(
                        delYnEq(requestDto.getDelYn())

                )
                .orderBy(QBoard.board.boardId.desc())

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
     *     전체 카운트를 조회 하는 방법을 최적화 할 수 있으면 이렇게 분리하면 된다. (예를 들어서 전체 카운트를
     * 조회할 때 조인 쿼리를 줄일 수 있다면 상당한 효과가 있다.)
     * 코드를 리펙토링해서 내용 쿼리과 전체 카운트 쿼리를 읽기 좋게 분리하면 좋다
     */
    @Override
    public Page<BoardListResponseDto> searchPageComplex(BoardListRequestDto requestDto, Pageable pageable) {
        List<BoardListResponseDto> content = jpaQueryFactory
                .select(new QBoardListResponseDto(
                        QBoard.board.boardTitle,
                        QBoard.board.createDate,
                        QBoard.board.modifyDate

                ))
                .from(QBoard.board)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch(); //콘텐츠쿼리 두번 날림

            long total = jpaQueryFactory
                    .select(QBoard.board)
                    .from(QBoard.board)
                    .where(
                            boardTitleEq(requestDto.getBoardTitle())
                    ).fetchCount(); //데이터가 몇천건 있을때 사용

        return new PageImpl<>(content, pageable, total);
    }



    /**
     * count 쿼리가 생략 가능한 경우 생략해서 처리
     * 페이지 시작이면서 컨텐츠 사이즈보다 작을때
     * 마지막 페이지 일 때(offset + 컨텐츠 사이즈를 더해서 전체 사이즈 구함)
     * @return
     */
    @Override
    public Page<BoardListResponseDto> searchPageComplex_v2(BoardListRequestDto requestDto, Pageable pageable) {
        List<BoardListResponseDto> content = jpaQueryFactory
                .select(new QBoardListResponseDto(
                        QBoard.board.boardTitle,
                        QBoard.board.createDate,
                        QBoard.board.modifyDate
                ))
                .from(QBoard.board)
                .where(
/*                        categoryNameEq(requestDto.getCategoryName()),
                        boardTitleEq(requestDto.getBoardTitle()),*/
                        delYnEq(requestDto.getDelYn())
                    )
                .orderBy(QBoard.board.createDate.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch(); //콘텐츠쿼리 두번 날림

        JPAQuery<Board> countQuery = jpaQueryFactory  // 카운트 쿼리
                .select(QBoard.board)
                .from(QBoard.board)
                .where(
/*                        categoryNameEq(requestDto.getCategoryName()),
                        boardTitleEq(requestDto.getBoardTitle()),*/
                        delYnEq(requestDto.getDelYn())



                );

        return PageableExecutionUtils.getPage(content, pageable, () -> countQuery.fetchCount());
    }




//    private BooleanExpression categoryNameEq(String categoryName) {
//        return StringUtils.hasText(categoryName) ? QCategory.category.categoryName.eq(categoryName) : null;
//    } //문자열(String) 값 여부  : 공백, null 체크

    private BooleanExpression boardTitleEq(String boardTitle) {

        return StringUtils.hasText(boardTitle) ? QBoard.board.boardTitle.eq(boardTitle) : null;
    }

    private BooleanExpression delYnEq(String delYn) {

        return StringUtils.hasText(delYn = "N") ? QBoard.board.delYn.eq(delYn) : null;
    }



}

