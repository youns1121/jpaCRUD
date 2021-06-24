package com.jpacrud.controller;

import com.jpacrud.domain.Posts;

import com.jpacrud.dto.PostsRequestDto;
import com.jpacrud.dto.PostsResponseDto;
import com.jpacrud.dto.PostsUpdateRequestDto;
import com.jpacrud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(value ="/api/board")
public class BoardApiController{

    private final BoardService boardService;


    @Transactional
    @PostMapping("/create")// 게시판 생성 , 아이디를 반환
    public  Long createPosts (@RequestBody PostsRequestDto postsRequestDto) {

        return boardService.createPosts(postsRequestDto);
    }

    @GetMapping("/read/{id}") //게시판 조회, 아이디로 조회
    public PostsResponseDto findById(@PathVariable Long id){ // 게시판 조회, 아이디로 조회
        return boardService.findById(id);
    }

    @PutMapping("/update/{postsId}") // 게시판 수정
    public Long updatePosts(@PathVariable Long postsId, @RequestBody PostsUpdateRequestDto postsUpdateRequestDto){
        return boardService.updatePosts(postsId, postsUpdateRequestDto);
    }

    @DeleteMapping("/delete/{postsId}") // 게시판 삭제
    public void deletePosts (@PathVariable Long postsId){


    }







}
