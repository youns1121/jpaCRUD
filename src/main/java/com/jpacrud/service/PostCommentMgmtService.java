package com.jpacrud.service;

import com.jpacrud.domain.BoardPost;
import com.jpacrud.domain.PostComment;
import com.jpacrud.dto.PostCommentDto;
import com.jpacrud.repository.PostCommentRepository;
import com.jpacrud.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class PostCommentMgmtService {

    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;

    /**
     * 댓글 생성하기
     * @param postCommentDto
     * @return
     */
    public Long createPostComment(PostCommentDto postCommentDto) {

        BoardPost boardPost = postRepository.findById(postCommentDto.getPostsId()).orElseThrow(()
                -> new NoSuchElementException("postsId not found"));
        postCommentDto.setBoardPost(boardPost);

        PostComment postComment = new PostComment();
        postComment.createComment(postCommentDto);

        return postCommentRepository.save(postComment).getPostCommentId();
    }

    /**
     * 대댓글 생성하기
     */

    @Transactional
    public Long createPostReplyComment(PostCommentDto postCommentDto){

        PostComment postComment = postCommentRepository.findById(postCommentDto.getPostCommentId()).orElseThrow(()
                -> new NoSuchElementException("postCommentId not found"));

        postCommentDto.setPostComment(postComment);

        postComment.createReplyComment(postCommentDto);

        postCommentRepository.save(postComment);
    }

    /**
     * 댓글 삭제하기
     */
    @Transactional
    public void deletePostComment(PostCommentDto postCommentDto){

        BoardPost boardPost = postRepository.findById(postCommentDto.getPostsId()).orElseThrow(()
                -> new NoSuchElementException("postsId not found"));
        postCommentDto.setBoardPost(boardPost);

        postCommentRepository.deleteById(postCommentDto.getPostCommentId());

    }

}
