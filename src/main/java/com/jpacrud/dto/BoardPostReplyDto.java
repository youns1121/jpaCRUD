package com.jpacrud.dto;

import com.jpacrud.domain.BoardPost;
import com.jpacrud.domain.PostReply;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardPostReplyDto { // 답글 생성


    private Long postsId;


    private String postReplyTitle;

    private String postReplyContent;

    private BoardPost boardPost;

    private List<PostReply> PostReply;


}
