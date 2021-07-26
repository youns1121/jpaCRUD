package com.jpacrud.service;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.BoardPost;

import com.jpacrud.domain.BoardPostReply;
import com.jpacrud.dto.BoardPostReplyDto;
import com.jpacrud.dto.PostDto;
import com.jpacrud.repository.BoardRepository;
import com.jpacrud.repository.PostReplyRepository;
import com.jpacrud.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BoardPostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;
    private final PostReplyRepository postReplyRepository;




    /**
     * 생성하기
     */
    public Long createPosts(PostDto postDto) { // 게시글 생성 (아이디 반환)

        Board board = boardRepository.findById(postDto.getBoardId()).orElse(null);

        postDto.setBoard(board);

        BoardPost boardPost = new BoardPost();
        boardPost.createPosts(postDto);

        return postRepository.save(boardPost).getPostsId();
    }


    /**
     * 수정하기
     */

    @Transactional
    public Long updatePosts(PostDto postDto) {

        BoardPost boardPost = postRepository.findById(postDto.getPostsId()).orElse(null);

        boardPost.createPosts(postDto);

        return postRepository.save(boardPost).getPostsId();
    }

    /**
     * 삭제하기
     */
    public void deletePosts(PostDto postDto) { // 게시글 삭제하기
        postRepository.deleteById(postDto.getPostsId());

    }

    /**
     * 댓글 작성하기
     * @return
     */

    public BoardPostReply createReply(BoardPostReplyDto replyDto){


        BoardPost boardPost = postRepository.findById(replyDto.getPostsId()).orElse(null);
        replyDto.setBoardPost(boardPost);

        BoardPostReply boardPostReply = new BoardPostReply();
        boardPostReply.create(replyDto);

        return postReplyRepository.save(boardPostReply);



    }



//    public Optional<BoardPost> getPost(long postId) { // 게시물id로 게시물 단건 조회
//
//        return postRepository.findById(postId);
//    }


//





}
