package com.jpacrud.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private MemberStatus status; // 계정 활성화 여부


    @OneToMany(mappedBy = "member")
    private List<Lend> lends = new ArrayList<>();




}
