package com.jpacrud.service.impl;

import com.jpacrud.domain.Board;
import com.jpacrud.dto.BoardDto;
import com.jpacrud.dto.BoardMgmtDto;
import com.jpacrud.repository.BoardRepository;
import com.jpacrud.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;


    public Long createBoard(BoardMgmtDto boardMgmtDto){
        return boardRepository.save(Board.createBoard(boardMgmtDto)).getBoardId();
    }

    @Transactional
    public Long createPosts(BoardMgmtDto boardMgmtDto){
        return boardRepository.save(Board.createPosts(boardMgmtDto)).getBoardId();
    }

}
