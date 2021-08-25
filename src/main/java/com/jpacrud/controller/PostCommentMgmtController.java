package com.jpacrud.controller;

import com.jpacrud.dto.PostCommentDto;
import com.jpacrud.service.PostCommentMgmtService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "댓글 관리 API", tags = "댓글 관리 API")
@RequiredArgsConstructor
@RestController
@RequestMapping(value ="/v1/api")
public class PostCommentMgmtController {

    private final PostCommentMgmtService postCommentMgmtService;

    @ApiOperation(value = "댓글 생성", notes = "댓글을 생성합니다.")
    @PostMapping("/createPostComment")
    public ResponseEntity<Long> createPostComment (@RequestBody PostCommentDto postCommentDto){

        return ResponseEntity.ok(postCommentMgmtService.createPostComment(postCommentDto));
    }


    @ApiOperation(value = "댓글 삭제", notes = "댓글을 삭제합니다.")
    @DeleteMapping("/deletePostComment/{postsId}/{postCommentId}")
    public void deletePostComment (@RequestBody PostCommentDto postCommentDto){

        postCommentMgmtService.deletePostComment(postCommentDto);
    }
}
