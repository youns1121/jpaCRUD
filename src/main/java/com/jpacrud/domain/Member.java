package com.jpacrud.domain;

import com.jpacrud.domain.common.BaseEntity;
import com.jpacrud.dto.MemberDto;
import com.jpacrud.enums.StatusEnums;
import com.jpacrud.mapper.MemberMapperImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @Column(name = "id")
    private Long id;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private StatusEnums.UserRole userRole;

    @OneToMany(mappedBy = "member")
    private List<Board> boardList = new ArrayList<>();


    /**
     * 유저 생성
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
        this.userRole = memberDto.getUserRole();

    }


//    public Member createUserBuilder(MemberDto memberDto){
//        Member member = Member.builder()
//
//                  .memberId(memberDto.getMemberId())
//                  .build();
//
//
//        return member;
//
//
//    }

}
