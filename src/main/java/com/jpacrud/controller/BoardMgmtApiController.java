package com.jpacrud.controller;

import com.jpacrud.dto.BoardDto;

import com.jpacrud.dto.BoardReplyDto;
import com.jpacrud.dto.request.BoardListRequestDto;
import com.jpacrud.dto.response.BoardListResponseDto;
import com.jpacrud.service.BoardMgmtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "게시판 관리 API", tags = "게시판 관리 API")
@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/v2/api")
public class BoardMgmtApiController {

    private final BoardMgmtService boardMgmtService;



    @ApiOperation(value = "게시판 생성", notes = "게시판을 생성합니다.")
    @PostMapping("/createBoard")
    public ResponseEntity<Long> createBoard (@RequestBody BoardDto boardDto)  {

        return ResponseEntity.ok(boardMgmtService.createBoard(boardDto));
    }

    @ApiOperation(value = "게시판 수정", notes = "게시판을 수정합니다.")
    @PostMapping("/updateBoard/{boardId}")
    public ResponseEntity<Long> updateBoard (@RequestBody BoardDto boardDto) {

        return ResponseEntity.ok(boardMgmtService.updateBoard(boardDto));
    }


    /**
     * 답글 생성
     */
    @ApiOperation(value = "게시판 답글 생성", notes = "게시판의 답글을 생성합니다.")
    @PostMapping("/createReply/{boardId}") //
    public ResponseEntity<Long> createBoardReply (@RequestBody BoardReplyDto replyDto){

        return ResponseEntity.ok(boardMgmtService.createBoardReply(replyDto));

    }

    @ApiOperation(value = "게시판 삭제", notes = "게시판을 삭제합니다.")
    @PostMapping("/deleteBoard/{boardId}")
    public void deleteBoard (@RequestBody BoardDto boardDto) {

        boardMgmtService.deleteBoard(boardDto);
    }



    /**
     * 카테고리별 게시판 조회
     * @return
     */
    @ApiOperation(value = "카테고리별 전체 게시판 조회", notes = "카테고리별 전체 게시판 조회 합니다.")
    @GetMapping("/searchSimpleBoard")
    public List<BoardListResponseDto> getBoardLSimple(BoardListRequestDto requestDto){

        List<BoardListResponseDto> boardList = boardMgmtService.searchSimpleList(requestDto);
        return boardList;
    }

    /**
     * 카테고리별 게시판 페이징 조회
     * @return
     */
    @ApiOperation(value = "카테고리별  게시판 페이징 조회", notes = "카테고리별 게시판 페이징 조회 합니다.")
    @GetMapping("/searchPageList")
    public Page<BoardListResponseDto> getBoardPage(BoardListRequestDto requestDto, Pageable pageable){

        Page<BoardListResponseDto> boardListResponseDtos = boardMgmtService.searchPageList(requestDto, pageable);
        return boardListResponseDtos;
    }


    /**
     * 카테고리별 게시판 페이징 Complex
     */

    @ApiOperation(value = "카테고리별 게시판 페이징 Complex", notes = "카테고리별 게시판 페이징 Complex을 조회 합니다.")
    @GetMapping("/searchPageComplexBoard")
    public Page<BoardListResponseDto> getBoardComplexBoard(BoardListRequestDto requestDto, Pageable pageable){

        Page<BoardListResponseDto> boardListResponseDtos = boardMgmtService.searchPageComplex(requestDto, pageable);

        return boardListResponseDtos;
    }

    /**
     * 카테고리별 게시판 페이징 Complex_v2
     */

    @ApiOperation(value = "카테고리별 게시판 페이징 Complex_v2", notes = "카테고리별 게시판 페이징 Complex_v2을 조회 합니다.")
    @GetMapping("/searchPageComplexV2Board")
    public Page<BoardListResponseDto> getBoardComplexV2Board(BoardListRequestDto requestDto, Pageable pageable){

        Page<BoardListResponseDto> boardListResponseDtos = boardMgmtService.searchPageComplexV2(requestDto, pageable);

        return boardListResponseDtos;
    }



}
