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
public class BoardPostReplyDto {

    private Long postsId;

    private BoardPost boardPost;

    private String replyContent;

}
