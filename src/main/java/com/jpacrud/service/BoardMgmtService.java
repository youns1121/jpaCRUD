package com.jpacrud.service;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.BoardReply;
import com.jpacrud.domain.Category;
import com.jpacrud.dto.BoardReplyDto;
import com.jpacrud.dto.BoardDto;
import com.jpacrud.dto.request.BoardListRequestDto;
import com.jpacrud.dto.response.BoardListResponseDto;
import com.jpacrud.repository.CategoryRepository;
import com.jpacrud.repository.BoardReplyRepository;
import com.jpacrud.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;


@RequiredArgsConstructor
@Service
public class BoardMgmtService {

    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;
    private final BoardReplyRepository boardReplyRepository;




    /**
     * 게시판 생성하기
     */
    @Transactional
    public Long createPosts(BoardDto boardDto){


        Category category = categoryRepository.findById(boardDto.getCategoryId()).orElseThrow(() -> new NoSuchElementException("categoryId not found"));

        boardDto.setCategory(category);

        Board board = new Board();

        board.create(boardDto);

        return boardRepository.save(board).getBoardId();





    }


    /**
     * 수정하기
     */

    @Transactional
    public Long updateBoard(BoardDto boardDto) {

        Board board = boardRepository.findById(boardDto.getBoardId()).orElseThrow(()->
                new NoSuchElementException("boardId not found")
        );

        board.create(boardDto);

        return boardRepository.save(board).getBoardId();
    }

    /**
     * 삭제하기
     */
    @Transactional
    public void deleteBoard(BoardDto boardDto) {
        boardRepository.deleteById(boardDto.getBoardId());

    }

    /**
     * 답글 작성하기
     * @return
     */

    @Transactional
    public Long createBoardReply(BoardReplyDto replyDto){


        Board board = boardRepository.findById(replyDto.getBoardId()).orElseThrow(() -> new NoSuchElementException("boardId not found"));

        replyDto.setBoard(board);

        BoardReply boardReply = new BoardReply();
        boardReply.create(replyDto);

        return boardReplyRepository.save(boardReply).getBoardReplyId();
    }

    /**
     * 게시판 전체 리스트 조회 -간단 조회
     * @param
     * @return
     */

    @Transactional
    public List<BoardListResponseDto> findBoardList(){


        return null;
    }


//    @Transactional(readOnly = true)
//    public Page<BoardListDto> boardList(Pageable pageable) {
//
//        Page<Board> boardList = boardRepository.findAll(pageable);
//
//        Page<BoardListDto> boardListDtoPage = boardList.map(
//                board -> new BoardListDto(
//                        board.getCategory().getCategoryId(), board.getBoardId(), board.getBoardTitle(), board.getCreateDate()
//                ));
//        return boardListDtoPage;
//    }




}
