package com.jpacrud.controller;

import com.jpacrud.dto.BoardCommentDto;
import com.jpacrud.service.BoardCommentMgmtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "댓글 관리 API", tags = "댓글 관리 API")
@RequiredArgsConstructor
@RestController
@RequestMapping(value ="/api/v1")
public class PostCommentMgmtController {

    private final BoardCommentMgmtService boardCommentMgmtService;

    @ApiOperation(value = "댓글 생성", notes = "댓글을 생성합니다.")
    @PostMapping("/createPostComment")
    public ResponseEntity<Long> createPostComment (@RequestBody BoardCommentDto boardCommentDto){

        return ResponseEntity.ok(boardCommentMgmtService.createBoardComment(boardCommentDto));
    }

//    @ApiOperation(value = "대댓글 생성", notes = "대댓글을 생성합니다.")
//    @PostMapping("/createPostReplyComment")
//    public ResponseEntity<Long> createPostReplyComment (@RequestBody BoardCommentDto boardCommentDto){
//
//        return ResponseEntity.ok(boardCommentMgmtService.createPostReplyComment(boardCommentDto));
//    }


    @ApiOperation(value = "댓글 삭제", notes = "댓글을 삭제합니다.")
    @DeleteMapping("/deletePostComment/{postsId}/{postCommentId}")
    public void deletePostComment (@RequestBody BoardCommentDto boardCommentDto){

        boardCommentMgmtService.deletePostComment(boardCommentDto);
    }
}
