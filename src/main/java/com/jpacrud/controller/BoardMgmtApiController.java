package com.jpacrud.controller;

import com.jpacrud.dto.BoardReplyDto;
import com.jpacrud.dto.BoardDto;
import com.jpacrud.dto.response.BoardListResponseDto;
import com.jpacrud.service.BoardMgmtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(value = "게시판 관리 API", tags = "게시판 관리 API")
@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/api/v1")
public class BoardMgmtApiController {

    private final BoardMgmtService boardMgmtService;



    @ApiOperation(value = "게시판 생성", notes = "게시판을 생성합니다.")
    @PostMapping("/createBoard")
    public ResponseEntity<Long> createBoard (@RequestBody BoardDto boardDto)  {

        return ResponseEntity.ok(boardMgmtService.createPosts(boardDto));
    }

    @ApiOperation(value = "게시판 수정", notes = "게시판을 수정합니다.")
    @PostMapping("/updateBoard/{boardId}")
    public ResponseEntity<Long> updateBoard (@RequestBody BoardDto boardDto) {

        return ResponseEntity.ok(boardMgmtService.updateBoard(boardDto));
    }


    /**
     * 답글 생성
     * @param replyDto
     * @return
     */
    @ApiOperation(value = "게시판 답글 생성", notes = "게시판의 답글을 생성합니다.")
    @PostMapping("/createReply/{boardId}") //
    public ResponseEntity<Long> createBoardReply (@RequestBody BoardReplyDto replyDto){

        return ResponseEntity.ok(boardMgmtService.createBoardReply(replyDto));
    }

    @ApiOperation(value = "게시판 삭제", notes = "게시판을 삭제합니다.")
    @DeleteMapping("/deleteBoard/{boardId}")
    public void deleteBoard (@RequestBody BoardDto boardDto) {

        boardMgmtService.deleteBoard(boardDto);
    }


    /**
     * 게시판 목록 조회
     */
    @ApiOperation(value = "게시판 목록 조회", notes = "게시판의 목록을 조회 합니다.")
    @GetMapping("/boardList")
    public Page<BoardListResponseDto> getBoardList(Pageable pageable){

        return null;
//        return boardMgmtService.boardList(pageable);
    }
}
