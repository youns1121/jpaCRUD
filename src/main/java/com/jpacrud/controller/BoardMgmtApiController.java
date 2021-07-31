package com.jpacrud.controller;

import com.jpacrud.dto.BoardDto;
import com.jpacrud.dto.BoardMgmtDto;
import com.jpacrud.dto.BoardPostReplyDto;
import com.jpacrud.dto.PostDto;
import com.jpacrud.service.BoardPostService;
import com.jpacrud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/api")
public class BoardMgmtApiController {



    private final BoardService boardService;
    private final BoardPostService postsService;




    @PostMapping("/createBoard") //게시판 생성
    public ResponseEntity<Long> createBoard (@RequestBody BoardDto boardDto){

        return ResponseEntity.ok(boardService.createBoard(boardDto));
    }


    @PostMapping("/createPost") //게시물 생성
    public ResponseEntity<Long> createPost (@RequestBody PostDto postDto){

        return ResponseEntity.ok(postsService.createPosts(postDto));
    }

    @PostMapping("/updatePost/{postsId}") //게시물 수정
    public ResponseEntity<Long> updatePost (@RequestBody PostDto postDto) {

        return ResponseEntity.ok(postsService.updatePosts(postDto));
    }

    @PostMapping("/createReply/{postsId}") // 게시글 답글 생성
    public ResponseEntity<Long> createReply (@RequestBody BoardPostReplyDto replyDto){

        return ResponseEntity.ok(postsService.createReply(replyDto).getReplyId());
    }



    @DeleteMapping("/deletePost/{postsId}") //게시물 삭제
    public void deletePost (@RequestBody PostDto postDto) {

        postsService.deletePosts(postDto);
    }

//    @GetMapping("/read/{id}") //게시판 조회, 아이디로 조회
//    public PostsResponseDto findById(@PathVariable Long id){ // 게시판 조회, 아이디로 조회
//        return postsService.findById(id);
//    }

//    @PutMapping("/update/{postsId}") // 게시판 수정
//    public Long updatePosts(@PathVariable Long postsId, @RequestBody PostsUpdateRequestDto postsUpdateRequestDto){
//        return postsService.updatePosts(postsId, postsUpdateRequestDto);
//    }
//
//    @DeleteMapping("/delete/{postsId}") // 아이디로 게시판 삭제
//    public void deletePosts (@PathVariable Long postsId){
//        postsService.deletePosts(postsId);
//    }
//
//





}
