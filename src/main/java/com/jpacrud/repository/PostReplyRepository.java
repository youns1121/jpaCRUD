package com.jpacrud.repository;

import com.jpacrud.domain.BoardPostReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostReplyRepository extends JpaRepository<BoardPostReply, Long> {
}
