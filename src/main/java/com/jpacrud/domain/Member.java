package com.jpacrud.domain;

import com.jpacrud.domain.common.BaseEntity;
import com.jpacrud.dto.MemberDto;

import com.jpacrud.enums.StatusEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "warning")
    private int warning = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private StatusEnums.UserRole userRole;

    @OneToMany(mappedBy = "member")
    private List<Board> boardList = new ArrayList<>();



    @OneToMany(mappedBy = "member")
    private List<Category> categoryList = new ArrayList<>();




    /**
     * 회원가입
     * 초기 가입은 일반사용자
     */

    @Builder
    public void createUser(MemberDto memberDto){

        this.memberId = memberDto.getMemberId();
        this.password = memberDto.getPassword();
        this.name = memberDto.getName();
        this.age = memberDto.getAge();
        this.email = memberDto.getEmail();
        this.gender = memberDto.getGender();
        this.phone = memberDto.getPhone();
        this.userRole = memberDto.getUserRole().USER_NONE;
    }
}
