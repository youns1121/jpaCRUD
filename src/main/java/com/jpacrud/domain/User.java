package com.jpacrud.domain;

import com.jpacrud.domain.common.BaseEntity;
import com.jpacrud.enums.StatusEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "name")
    private String name;

    @Column(name = "user_age")
    private int userAge;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_gender")
    private String userGender;

    @Column(name = "user_phone")
    private String userPhone;

    private StatusEnums.UserRole userRole;

}
