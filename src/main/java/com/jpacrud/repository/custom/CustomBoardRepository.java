package com.jpacrud.repository.custom;

import com.jpacrud.domain.Board;
import com.jpacrud.dto.request.BoardListRequestDto;
import com.jpacrud.dto.response.BoardListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomBoardRepository {

    Page<BoardListResponseDto> searchBoardList(BoardListRequestDto requestDto, Pageable pageable);

}
