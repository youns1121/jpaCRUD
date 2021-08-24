package com.jpacrud.controller;

import com.jpacrud.dto.BoardDto;
import com.jpacrud.dto.BoardPostReplyDto;
import com.jpacrud.dto.PostDto;
import com.jpacrud.service.BoardPostService;
import com.jpacrud.service.BoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "게시판 관리 API", tags = "게시판 관리 API")
@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/v1/api")
public class BoardMgmtApiController {



    private final BoardService boardService;




    @ApiOperation(value = "게시판 생성", notes = "게시판을 생성합니다.")
    @PostMapping("/createBoard")
    public ResponseEntity<Long> createBoard (@RequestBody BoardDto boardDto){

        return ResponseEntity.ok(boardService.createBoard(boardDto));
    }

    @ApiOperation(value = "게시판 이름 수정", notes = "게시판 이름을 수정합니다.")
    @PostMapping("/updateBoard")
    public ResponseEntity<Long> updateBoard (@RequestBody BoardDto boardDto){

        return ResponseEntity.ok(boardService.updateBoard(boardDto));
    }

    @ApiOperation(value = "게시판 삭제", notes = "게시판을을 삭제 합니다.")
    @DeleteMapping("/deleteBoard{boardId}")
    public void deleteBoard (@RequestBody BoardDto boardDto){

        boardService.deleteBoard(boardDto);
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
