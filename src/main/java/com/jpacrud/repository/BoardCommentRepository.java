package com.jpacrud.repository;

import com.jpacrud.domain.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCommentRepository extends JpaRepository<BoardComment, Long> {


//    public void getReplyComment(){ }
}
