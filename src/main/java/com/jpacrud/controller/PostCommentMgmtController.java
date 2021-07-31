package com.jpacrud.controller;

import com.jpacrud.dto.BoardDto;
import com.jpacrud.dto.PostCommentDto;
import com.jpacrud.service.PostCommentMgmtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value ="/api")
public class PostCommentMgmtController {

    private final PostCommentMgmtService postCommentMgmtService;

    @PostMapping("/createPostComment") // 댓글 생성
    public ResponseEntity<Long> createBoard (@RequestBody PostCommentDto postCommentDto){

        return ResponseEntity.ok(postCommentMgmtService.createPostComment(postCommentDto));
    }
}
