package com.jpacrud.repository;

import com.jpacrud.domain.Board;
import com.jpacrud.repository.custom.CustomBoardRepository;
import lombok.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

public interface BoardRepository extends JpaRepository<Board, Long>, CustomBoardRepository {
//    List<BoardPost> findByBoard(Board board); // 게시판의 모든 게시글을 조회하기 위한 메서드, 객체 자체를 인자로 주입
}

