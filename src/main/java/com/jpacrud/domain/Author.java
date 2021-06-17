package com.jpacrud.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue

    @Column(name="author_id")
    private Long authorId;

    @Column(name = "author_name")
    private String authorName;



    @JsonBackReference
    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();
}
