package com.jpacrud.domain;

import com.jpacrud.domain.common.CommonDateEntity;
import com.jpacrud.dto.BoardMgmtDto;
import com.jpacrud.dto.BoardPostReplyDto;
import com.jpacrud.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "board_post_reply")
@Entity
public class BoardPostReply extends CommonDateEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long replyId;

    @Column(name = "reply_content")
    private String replyContent;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private BoardPost boardPost;


    /**
     * 댓글 생성 로직
     */

    public void create(BoardPostReplyDto replyDto){
        this.boardPost = BoardPost.builder()
                .postsId(replyDto.getPostsId())
                .build();
        this.replyContent = replyDto.getReplyContent();
    }


}
