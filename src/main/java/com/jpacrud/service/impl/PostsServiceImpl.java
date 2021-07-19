//package com.jpacrud.service.impl;
//
//import com.jpacrud.domain.Posts;
//import com.jpacrud.dto.BoardDto;
//import com.jpacrud.dto.PostsRequestDto;
//import com.jpacrud.dto.PostsUpdateRequestDto;
//import com.jpacrud.repository.PostRepository;
//import com.jpacrud.service.PostsService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.Optional;
//
////@RequiredArgsConstructor
////@Service
////public class PostsServiceImpl implements PostsService {
//
////    private final PostRepository postRepository;
//
//
//
//    /**
//     * 생성하기
//     */
////    public Long createPosts(BoardDto requestDto) { // 게시판 생성 (아이디 반환)
////
////        return postRepository.save(Posts.createPosts(requestDto)).getPostsId();
////    }
//
//    /**
//     * 조회하기
//     */
////    @Transactional
////    public PostsResponseDto findById(Long id) { //특정 게시글 아이디로 조회하여 검색
////        Posts posts = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
////
////        return new PostsResponseDto(posts);
////    }
//
//
//    public Optional<Posts> getPost(long postId) { // 게시물id로 게시물 단건 조회
//
//        return postRepository.findById(postId);
//    }
//
//
//
//    /**
//     * 수정하기
//     */
//
//    @Transactional
//    public Long updatePosts(Long id, PostsUpdateRequestDto postsUpdateRequestDto) {
//
//        Posts posts = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
//
//        posts.setUpdate(postsUpdateRequestDto.getTitle(), postsUpdateRequestDto.getContent());
//
//        return id;
//    }
//
//    /**
//     * 삭제하기
//     */
//    public void deletePosts(Long postsId) { // 게시글 삭제하기
//        postRepository.deleteById(postsId);
//
//    }
//
//
//}
