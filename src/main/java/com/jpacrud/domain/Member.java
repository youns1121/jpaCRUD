package com.jpacrud.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

@Table(name="member")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private long memberId;

    @Column(name="member_name")
    private String memberName;

    @Enumerated(EnumType.STRING)
    @Column(name="member_status")
    private MemberStatus status;





}
