package com.jpacrud.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="lend") //대출
public class Lend {


    @Id
    @GeneratedValue
    @Column(name ="lend_id")
    private Long lendId;

    @Column(name = "lend_name")
    private String lendName;


    @Enumerated(EnumType.ORDINAL)
    @Column(name = "lend_status")
    private LendStatus status;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;


}
