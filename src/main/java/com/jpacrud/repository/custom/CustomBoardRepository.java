package com.jpacrud.repository.custom;

import com.jpacrud.domain.Board;
import com.jpacrud.dto.request.BoardListRequestDto;
import com.jpacrud.dto.response.BoardListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomBoardRepository {

    Page<BoardListResponseDto> searchPageList(BoardListRequestDto requestDto, Pageable pageable);

    List<BoardListResponseDto> searchSimpleList(BoardListRequestDto requestDto);


}
