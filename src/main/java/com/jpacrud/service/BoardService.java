package com.jpacrud.service;

import com.jpacrud.domain.Board;
import com.jpacrud.domain.Posts;
import com.jpacrud.dto.PostsRequestDto;
import com.jpacrud.dto.PostsResponseDto;
import com.jpacrud.dto.PostsUpdateRequestDto;
import com.jpacrud.repository.BoardRepository;
import com.jpacrud.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {


    private final PostRepository postRepository;


    /**
     * 조회하기
     */
    @Transactional
    public PostsResponseDto findById(Long id) { //특정 게시글 아이디로 조회하여 검색
        Posts posts = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostsResponseDto(posts);
    }


//    public Board findBoard(String boardName) { //게시판 이름으로 게시판조회
//
//        return boardRepository.findByName(boardName);
//    }
//    public List<Posts> findPosts(String boardName) { // 게시판 이름으로 게시물 리스트 조회
//        return postRepository.findByBoard(findBoard(boardName));
//    }

    public Optional<Posts> getPost(long postId) { // 게시물id로 게시물 단건 조회

        return postRepository.findById(postId);
    }

    /**
     * 생성하기
     */
    public Long createPosts(PostsRequestDto postsRequestDto) { // 게시판 생성 (아이디 반환)

        return postRepository.save(postsRequestDto.toEntity()).getPostsId();
    }

    /**
     * 수정하기
     */

    @Transactional
    public Long updatePosts(Long id, PostsUpdateRequestDto postsUpdateRequestDto) {

        Posts posts = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        posts.setUpdate(postsUpdateRequestDto.getTitle(), postsUpdateRequestDto.getContent());

        return id;
    }

    /**
     * 삭제하기
     */
//    public Long deletePosts(Long postsId) {
//
//        return postRepository.deleteById();
//    }



}

//    @Transactional
//    public Long createBoard(BoardDto boardDto) { // 게시글 생성
//
//        return boardRepository.save(boardDto.toEntity()).getId();
//    }
//
//    public List<BoardDto> boardList() { // 게시글 리스트 보여주기
//        List<Board> boardList = boardRepository.findAll();
//        List<BoardDto> boardDtoList = new ArrayList<>();
//        for (Board board : boardList) {
//            BoardDto boardDto = BoardDto.builder()
//                    .id(board.getId())
//                    .title(board.getTitle())
//                    .content(board.getContent())
//                    .count(board.getCount())
//                    .build();
//
//            boardDtoList.add(boardDto);
//        }
//
//        return boardDtoList;








//    public Page<Board> listBoard(Pageable pageable){
//
//        return boardRepository.findAll(pageable);
//    }
//
//    public Board viewBoard(long id){
//        return boardRepository.findById(id)
//                .orElseThrow(()->{
//                    return new IllegalArgumentException("아이디를 찾을 수 없습니다");
//        });
//    }
//
//    public void deleteBoard(long id){
//        boardRepository.deleteById(id);
//    }
//
//    public Board changeBoard(long id, Board requestBoard){
//
//        boardRepository.findById(id)
//                .orElseThrow(()->{
//                    return new IllegalArgumentException("아이디를 찾을 수 없습니다.");
//                });
//        Board board = Board.builder()
//                .title()
//                .build()





