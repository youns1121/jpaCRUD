package com.jpacrud.repository;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.QBoard;
import com.jpacrud.domain.QCategory;
import com.jpacrud.dto.request.BoardListRequestDto;
import com.jpacrud.dto.response.BoardListResponseDto;
import com.jpacrud.dto.response.QBoardListResponseDto;
import com.jpacrud.repository.custom.CustomBoardRepository;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

public class BoardRepositoryImpl implements CustomBoardRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public BoardRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }


    @Override
    public Page<BoardListResponseDto> searchBoardList(BoardListRequestDto requestDto, Pageable pageable) {
            List<BoardListResponseDto> results = jpaQueryFactory
                .select(new QBoardListResponseDto(
                        QCategory.category.categoryId.as("categoryId"),
                        QCategory.category.categoryName.as("categoryName"),
                        QBoard.board.boardId.as("boardId"),
                        QBoard.board.boardTitle.as("boardTitle")
                ))
                .from(QBoard.board)
                .innerJoin(QBoard.board.category, QCategory.category)

                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Board> countBoard = jpaQueryFactory
                .select(QBoard.board)
                .from(QBoard.board)
                .innerJoin(QBoard.board.category, QCategory.category);


        return PageableExecutionUtils.getPage(results, pageable, () -> countBoard.fetchCount());

    }


}
