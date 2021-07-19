package com.jpacrud.domain;

import com.jpacrud.domain.common.CommonDateEntity;
import com.jpacrud.dto.BoardMgmtDto;
import com.jpacrud.dto.PostDto;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Posts extends CommonDateEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postsId;

    @Column(name = "post_title")
    private String title;

    @Column(name="post_content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="board_id")
    private Board board; // 게시글 : 게시판 , N:1 관계


    //연관관계 메서드



    public static Posts create(BoardMgmtDto boardMgmtDto){
       return Posts.builder()
               .title(boardMgmtDto.getPostDto().getTitle())
               .content(boardMgmtDto.getPostDto().getContent())
               .build();


    }

    public Posts setUpdate(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }


}
