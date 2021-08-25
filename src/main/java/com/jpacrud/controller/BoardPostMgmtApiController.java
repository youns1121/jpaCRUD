package com.jpacrud.controller;

import com.jpacrud.dto.BoardPostReplyDto;
import com.jpacrud.dto.PostDto;
import com.jpacrud.service.BoardPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(value = "게시글 관리 API", tags = "게시글 관리 API")
@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/v1/api")
public class BoardPostMgmtApiController {

    private final BoardPostService postsService;



    @ApiOperation(value = "게시글 생성", notes = "게시글을 생성합니다.")
    @PostMapping("/createPost")
    public ResponseEntity<Long> createPost (@RequestBody PostDto postDto)  {

        return ResponseEntity.ok(postsService.createPosts(postDto));
    }

    @ApiOperation(value = "게시글 수정", notes = "게시글을 수정합니다.")
    @PostMapping("/updatePost/{postsId}")
    public ResponseEntity<Long> updatePost (@RequestBody PostDto postDto) {

        return ResponseEntity.ok(postsService.updatePosts(postDto));
    }

    @ApiOperation(value = "답글 생성", notes = "게시글의 답글을 생성합니다.")
    @PostMapping("/createReply/{postsId}") //
    public ResponseEntity<Long> createReply (@RequestBody BoardPostReplyDto replyDto){

        return ResponseEntity.ok(postsService.createReply(replyDto));

    }


    @ApiOperation(value = "게시글 삭제", notes = "게시글을 삭제합니다.")
    @DeleteMapping("/deletePost/{postsId}")
    public void deletePost (@RequestBody PostDto postDto) {

        postsService.deletePosts(postDto);
    }
}
