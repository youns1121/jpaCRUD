package com.jpacrud.domain;

import com.jpacrud.domain.common.BaseDateEntity;
import com.jpacrud.dto.BoardPostReplyDto;
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
public class PostReply extends BaseDateEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long replyId;

    @Column(name = "reply_content")
    private String replyContent;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private BoardPost boardPost;


    /**
     *  답글 생성 로직
     */

    public void create(BoardPostReplyDto replyDto){
        this.boardPost = BoardPost.builder()
                .postsId(replyDto.getPostsId())
                .build();
        this.replyContent = replyDto.getReplyContent();
    }


}
