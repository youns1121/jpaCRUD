package com.jpacrud.service;

import com.jpacrud.domain.Board;
import com.jpacrud.dto.BoardDto;
import com.jpacrud.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;


    /**
     * 게시판 생성
     * @param boardDto
     * @return
     */
    public Long createBoard(BoardDto boardDto){

        Board board = new Board();

        board.create(boardDto);



        return boardRepository.save(board).getBoardId();
    }

}
