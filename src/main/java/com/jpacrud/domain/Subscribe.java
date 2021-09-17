package com.jpacrud.domain;

import com.jpacrud.domain.common.BaseEntity;
import com.jpacrud.enums.StatusEnums;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="subscribe")
@Entity
public class Subscribe extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subscribe_id", columnDefinition = "BIGINT unsigned comment '구독 아이디'")
    private Long subscribeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private StatusEnums.UserRole userRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_seq")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "subscribe")
    private List<Likes> likesList = new ArrayList<>();

    @OneToMany(mappedBy = "subscribe")
    private List<Scrap> scrapList = new ArrayList<>();

    @OneToMany(mappedBy = "subscribe")
    private List<BoardComment> boardCommentList = new ArrayList<>();









}
