package com.jpacrud.domain;

import com.jpacrud.domain.common.BaseEntity;
import com.jpacrud.dto.CategoryDto;
import com.jpacrud.dto.MemberDto;

import com.jpacrud.enums.StatusEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

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
    @Column(name = "seq", columnDefinition = "BIGINT unsigned comment '회원 시퀀스'")
    private Long seq;

    @NotNull
    @UniqueElements
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

    @Column(name = "phone")
    private String phone;

    @NotNull
    @Column(name = "member_complain")
    private int Complain = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private StatusEnums.Gender gender;

//    @OneToMany(mappedBy = "member")
//    private List<Board> boardList = new ArrayList<>();

//    @OneToMany(mappedBy = "member")
//    private List<BoardComment> boardCommentList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Subscribe> subscribeList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Category> categoryList = new ArrayList<>();




    /**
     * 회원가입
     * 최초 권한 : NONE(권한없음)
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
    }

    /**
     * 카테고리 권한변경
     * @return
     */


}
