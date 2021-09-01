package com.jpacrud.service;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.BoardComment;
import com.jpacrud.dto.BoardCommentDto;
import com.jpacrud.repository.BoardCommentRepository;
import com.jpacrud.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;


@RequiredArgsConstructor
@Service
public class BoardCommentMgmtService {

    private final BoardRepository boardRepository;
    private final BoardCommentRepository boardCommentRepository;

    /**
     * 댓글 생성하기
     * @param
     * @return
     */
    public Long createBoardComment(BoardCommentDto boardCommentDto) {

        Board board = boardRepository.findById(boardCommentDto.getBoardId()).orElseThrow(()->
                 new NoSuchElementException("boardId not found"));
        boardCommentDto.setBoard(board);

        BoardComment boardComment = new BoardComment();
        boardComment.createComment(boardCommentDto);

        return boardCommentRepository.save(boardComment).getBoardCommentId();
    }

    /**
     * 대댓글 생성하기 : 미구현
     */
//    @Transactional
//    public Long createPostReplyComment(BoardCommentDto BoardCommentDto){
//
//        BoardComment  childComments = BoardCommentRepository.save(
//
//                BoardCommentRepository.findById(BoardCommentDto.getBoardCommentId()).orElseThrow(()
//                -> new NoSuchElementException("BoardCommentId not found"))
//        );
//
//        BoardCommentDto.setBoardComment(childComments);
//
//        childComments.createReplyComment(BoardCommentDto);
//
//        return childComments.getBoardCommentId();
//    }

    /**
     * 댓글 삭제하기
     */
//    @Transactional
//    public void deletePostComment(BoardCommentDto BoardCommentDto){
//
//        Board Board = BoardRepository.findById(BoardCommentDto.getBoardId()).orElseThrow(()
//                -> new NoSuchElementException("postsId not found"));
//        BoardCommentDto.setBoard(Board);
//
//        BoardCommentRepository.deleteById(BoardCommentDto.getBoardCommentId());
//
//    }

}
