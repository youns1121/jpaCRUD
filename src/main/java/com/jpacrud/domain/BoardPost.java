package com.jpacrud.domain;

import com.jpacrud.domain.common.CommonDateEntity;
import com.jpacrud.dto.PostDto;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class BoardPost extends CommonDateEntity {

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



    public static BoardPost createPosts(PostDto postDto){
       return BoardPost.builder()
               .title(postDto.getTitle())
               .content(postDto.getContent())
               .build();
    }





}
