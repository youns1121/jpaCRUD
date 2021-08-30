package com.jpacrud.repository;

import com.jpacrud.domain.Board;
import com.jpacrud.dto.request.BoardListRequestDto;
import com.jpacrud.dto.response.BoardListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select new com.jpacrud.dto.response.BoardListResponseDto(boardId, boardTitle, createDate) from Board")
    List<BoardListResponseDto> findBoardList();




//    @Query("select b
//            from board b join category c on (b.category_id = c.category_id)
//            where b.category_id = 1
//            order by b.board asc)
//    Page<Board> findAll(Pageable pageable); // 게시판의 모든 게시글을 조회하기 위한 메서드, 객체 자체를 인자로 주입
}

