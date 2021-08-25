package com.jpacrud.domain;

import com.jpacrud.domain.common.BaseDateEntity;
import com.jpacrud.domain.common.BaseEntity;
import com.jpacrud.dto.BoardPostReplyDto;
import com.jpacrud.dto.PostDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "board_post")
@Entity
public class BoardPost extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long postsId;

    @Column(name = "post_title")
    private String title;

    @Column(name="post_content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="board_id")
    private Board board; // 게시글 : 게시판 , N:1 관계


    @OneToMany(mappedBy = "boardPost", cascade = CascadeType.ALL)
    private List<PostReply> postReplyList = new ArrayList<>();

    @OneToMany(mappedBy = "boardPost", cascade = CascadeType.ALL)
    private List<PostComment> postCommentList = new ArrayList<>();


    /**
     * 게시글 생성 로직
     * @param postDto
     */
    public void createPosts(PostDto postDto){
        this.board = postDto.getBoard();
        this.title = postDto.getTitle();
        this.content = postDto.getContent();
    }

    /**
     * 답글 생성 로직
     */

//    public void addPostReply(PostReply postReply) {
//
//        boardPostReplyList.add(postReply);
//        postReply.setBoardPost(this);
//    }

//    public void createPostReply(BoardPostReplyDto boardPostReplyDto){
//       BoardPost boardPost = new BoardPost();
//       boardPost.addPostReply((PostReply) boardPostReplyDto.getPostReply());
//
//
//    }





//    public void createReply(BoardPostReplyDto replyDto){
//
//
//        BoardPostReply boardPostReply = new BoardPostReply();
//        boardPostReply.create(replyDto);
//    }

    /**
     * 업데이트 로직
     */







}
