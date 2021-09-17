package com.jpacrud.domain;

import com.jpacrud.domain.common.BaseEntity;

import com.jpacrud.dto.BoardDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "board")
@Entity
public class Board extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id", columnDefinition = "BIGINT unsigned comment '게시판 아이디'")
    private Long boardId;

    @Column(name="board_title", columnDefinition = "varchar(255) comment '게시판 제목'")
    private String boardTitle;

    @Column(name="board_content", columnDefinition = "varchar(255) comment '게시판 내용'")
    private String boardContent;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id", columnDefinition = "BIGINT unsigned comment '카테고리 아이디'")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subscribe_id", columnDefinition = "BIGINT unsigned comment '구독 아이디'")
    private Subscribe subscribe;

    @OneToMany(mappedBy = "board")
    private List<Likes> likesList = new ArrayList<>();

    @OneToMany(mappedBy = "board")
    private List<Scrap> scrapList = new ArrayList<>();

    /**
     * 게시판 생성 로직
     */
    @Builder
    public void createBoard(BoardDto boardDto) {

//        this.category = boardDto.getCategory();
        this.boardTitle = boardDto.getBoardTitle();
        this.boardContent = boardDto.getBoardContent();
    }

    /**
     * 업데이트 로직
     */







}
