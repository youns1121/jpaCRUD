package com.jpacrud.domain;

import javax.persistence.*;

@Entity

@Table(name="member")
public class Member{
    @Id @GeneratedValue
    @Column(name="id")
    private Long memberId;

    @Column(name="password")
    private String meberPassword;

    @Column(name="name")
    private String memberName;

    @ManyToOne
    Team team;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMeberPassword() {
        return meberPassword;
    }

    public void setMeberPassword(String meberPassword) {
        this.meberPassword = meberPassword;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
