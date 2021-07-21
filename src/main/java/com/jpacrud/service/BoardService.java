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


    public Long createBoard(BoardDto boardDto){

        return boardRepository.save(Board.createBoard(boardDto)).getBoardId();
    }

}
