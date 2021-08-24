package com.jpacrud.service;

import com.jpacrud.domain.Board;
import com.jpacrud.dto.BoardDto;
import com.jpacrud.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {

    /**
     *  관리자(admin) 권한예정
     */

    private final BoardRepository boardRepository;


    /**
     * 게시판 생성
     * @param boardDto
     * @return
     */
    @Transactional
    public Long createBoard(BoardDto boardDto){

        Board board = new Board();

        board.create(boardDto);

        return boardRepository.save(board).getBoardId();
    }

    /**
     * 게시판 수정
     */
    @Transactional
    public Long updateBoard(BoardDto boardDto){
        Board board = boardRepository.findById(boardDto.getBoardId()).orElse(null);

        boardDto.setBoard(board);


        board.create(boardDto);

        return boardRepository.save(board).getBoardId();
    }


    /**
     * 게시판 삭제
     */
    @Transactional
    public void deleteBoard(BoardDto boardDto){

        boardRepository.deleteById(boardDto.getBoardId());
    }

}
