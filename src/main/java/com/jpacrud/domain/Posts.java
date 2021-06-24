package com.jpacrud.domain;

import com.jpacrud.domain.common.CommonDateEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Posts extends CommonDateEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postsId;

    @Column(name = "post_author")
    private String author;

    @Column(name = "post_title")
    private String title;

    @Column(name="post_content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id")
    private Board board; // 게시글 : 게시판 , N:1 관계

    @Builder
    public Posts(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public Posts setUpdate(String title, String content) {
        this.title = title;
        this.content = content;
        return this;
    }

    public Posts() {
    }
}
