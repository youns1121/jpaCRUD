package com.jpacrud.repository;

import com.jpacrud.domain.Board;
import lombok.Builder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {

    Board findByName(String name); // Board 이름으로 조회하기


}

