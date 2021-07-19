package com.jpacrud.controller;

import com.jpacrud.dto.BoardDto;
import com.jpacrud.dto.BoardMgmtDto;
import com.jpacrud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/api")
public class BoardMgmtApiController {


    private final BoardService boardService;



    @Transactional
    @PostMapping("/createBoard") //게시판 생성
    public ResponseEntity<Long> createBoard (@RequestBody BoardMgmtDto boardMgmtDto){

        return ResponseEntity.ok(boardService.createBoard(boardMgmtDto));
    }

    @Transactional
    @PostMapping("/createPost") //게시물 생성
    public ResponseEntity<Long> createPost (@RequestBody BoardMgmtDto boardMgmtDto){

        return ResponseEntity.ok(boardService.createPosts(boardMgmtDto));
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
