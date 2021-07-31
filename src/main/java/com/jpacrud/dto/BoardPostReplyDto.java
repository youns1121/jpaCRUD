package com.jpacrud.dto;

import com.jpacrud.domain.BoardPost;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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


}
