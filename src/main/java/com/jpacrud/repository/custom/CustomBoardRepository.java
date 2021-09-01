package com.jpacrud.repository.custom;

import com.jpacrud.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomBoardRepository {

    Page<Board> findAll(Pageable pageable);

}
