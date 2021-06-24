package com.jpacrud.repository;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Posts, Long> {
    List<Posts> findByBoard(Board board); // 게시판의 모든 게시글을 조회하기 위한 메서드, 객체 자체를 인자로 주입
}
