package com.jpacrud.domain;

import javax.persistence.*;

@Entity

@Table(name="member")
public class Member{
    @Id @GeneratedValue
    @Column(name="id")
    private Long memberId;

    @Column(name="account")
    private String memberAccount;

    @Column(name="password")
    private String memberPassword;

    @Column(name="name")
    private String memberName;

//    @ManyToOne
//    private Team team;


    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(String memberAccount) {
        this.memberAccount = memberAccount;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
