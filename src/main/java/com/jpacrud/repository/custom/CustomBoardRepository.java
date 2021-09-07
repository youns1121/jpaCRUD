package com.jpacrud.repository.custom;

import com.jpacrud.domain.Board;
import com.jpacrud.dto.BoardDto;
import com.jpacrud.dto.request.BoardListRequestDto;
import com.jpacrud.dto.response.BoardListResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomBoardRepository {


    //조회관련
    List<BoardListResponseDto> searchSimpleList(BoardListRequestDto requestDto);
    Page<BoardListResponseDto> searchPageList(BoardListRequestDto requestDto, Pageable pageable);
    Page<BoardListResponseDto> searchPageComplex(BoardListRequestDto requestDto, Pageable pageable);
    Page<BoardListResponseDto> searchPageComplex_v2(BoardListRequestDto requestDto, Pageable pageable);

    //삭제관련
//    Long deleteBoard(BoardDto boardDto);

}
