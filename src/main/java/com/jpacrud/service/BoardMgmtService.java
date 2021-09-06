package com.jpacrud.service;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.BoardReply;
import com.jpacrud.domain.Category;
import com.jpacrud.dto.BoardDto;
import com.jpacrud.dto.BoardReplyDto;
import com.jpacrud.dto.request.BoardListRequestDto;
import com.jpacrud.dto.response.BoardListResponseDto;
import com.jpacrud.repository.BoardReplyRepository;
import com.jpacrud.repository.BoardRepository;
import com.jpacrud.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Long createBoard(BoardDto boardDto){


        Category category = categoryRepository.findById(boardDto.getCategoryId()).orElseThrow(() -> new NoSuchElementException("categoryId not found"));

        boardDto.setCategory(category);

        Board board = new Board();

        board.createBoard(boardDto);

        return boardRepository.save(board).getBoardId();

    }

    /**
     * 게시판 수정하기
     */

    @Transactional
    public Long updateBoard(BoardDto boardDto) {

        Board board = boardRepository.findById(boardDto.getBoardId()).orElseThrow(()->
                new NoSuchElementException("BoardId not found")
        );

        board.createBoard(boardDto);

        return boardRepository.save(board).getBoardId();
    }

    /**
     * 게시판 삭제하기
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
    public Long createBoardReply(BoardReplyDto boardreplyDto){


        Board board = boardRepository.findById(boardreplyDto.getBoardId()).orElseThrow(() -> new NoSuchElementException("CategoryId not found"));

        boardreplyDto.setBoard(board);

        BoardReply boardReply = new BoardReply();
        boardReply.create(boardreplyDto);

        return boardReplyRepository.save(boardReply).getBoardReplyId();
    }

    /**
     * 카테고리별 게시글 리스트 조회
     * @param
     * @return
     */

    @Transactional(readOnly = true)
    public List<BoardListResponseDto> searchSimpleList(BoardListRequestDto requestDto){

        return boardRepository.searchSimpleList(requestDto);

    }

    /**
     * 카테고리별 게시글 페이징 조회
     * @param requestDto
     * @param pageable
     * @return
     */
    @Transactional(readOnly = true)
    public Page<BoardListResponseDto> searchPageList(BoardListRequestDto requestDto, Pageable pageable){

        Page<BoardListResponseDto> boardListResponseDtos = boardRepository.searchPageList(requestDto, pageable);

        return boardListResponseDtos;
    }


//    @Transactional(readOnly = true)
//    public Page<CategoryListDto> CategoryList(Pageable pageable) {
//
//        Page<Category> CategoryList = CategoryRepository.findAll(pageable);
//
//        Page<CategoryListDto> CategoryListDtoPage = CategoryList.map(
//                Category -> new CategoryListDto(
//                        Category.getCategory().getCategoryId(), Category.getCategoryId(), Category.getCategoryTitle(), Category.getCreateDate()
//                ));
//        return CategoryListDtoPage;
//    }




}
