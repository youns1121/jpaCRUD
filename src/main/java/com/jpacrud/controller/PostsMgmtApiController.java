//package com.jpacrud.controller;
//
//import com.jpacrud.dto.PostsRequestDto;
//import com.jpacrud.service.PostsService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//
//import javax.transaction.Transactional;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping(value ="/api")
//public class PostsMgmtApiController {
//
//    private final PostsService postsService;
//
//
//    @Transactional
//    @PostMapping("/createPosts")// 게시물 생성 , 아이디를 반환
//    public  Long createPosts (@RequestBody PostsRequestDto postsRequestDto) {
//        return postsService.createPosts(postsRequestDto);
//    }
//}
