package com.jpacrud.service;

import com.jpacrud.dto.BoardDto;
import com.jpacrud.dto.BoardMgmtDto;

public interface BoardService {

    Long createBoard(BoardMgmtDto boardMgmtDto);

    Long createPosts(BoardMgmtDto boardMgmtDto);
}
