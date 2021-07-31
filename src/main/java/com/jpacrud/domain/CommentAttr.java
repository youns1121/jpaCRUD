package com.jpacrud.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;


@Getter

@Embeddable
public class CommentAttr implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_group_id")
    private Long commentGroupId;



}
