package com.jpacrud.service;

import com.jpacrud.domain.BoardPost;
import com.jpacrud.domain.PostComment;
import com.jpacrud.dto.PostCommentDto;
import com.jpacrud.repository.PostCommentRepository;
import com.jpacrud.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostCommentMgmtService {

    private final PostRepository postRepository;
    private final PostCommentRepository postCommentRepository;

    public Long createPostComment(PostCommentDto postCommentDto){

        BoardPost boardPost = postRepository.findById(postCommentDto.getPostsId()).orElse(null);
        postCommentDto.setBoardPost(boardPost);

        PostComment postComment = new PostComment();
        postComment.createComment(postCommentDto);

        return postCommentRepository.save(postComment).getCommentAttr().getCommentId();





    }

}
