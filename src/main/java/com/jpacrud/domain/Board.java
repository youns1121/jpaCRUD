package com.jpacrud.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.swing.plaf.basic.BasicButtonUI;

@Getter

@Entity
@Table(name="board")
public class Board { //게시판

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long boardId;

    @Column(name = "board_name")
    private String name;








    public Board() {
    }
}
