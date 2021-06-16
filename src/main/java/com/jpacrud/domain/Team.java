package com.jpacrud.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name="team")
public class Team {
    @Id
    @GeneratedValue

    @Column(name="id")
    private Long teamId;

    @Column(name="name")
    private String teamName;

    @Column(name="address")
    private String teamAddress;

    @OneToMany(mappedBy = "team")
    @JsonBackReference //순환참조 방지
    private List<Member> members = new ArrayList<>();




    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamAddress() {
        return teamAddress;
    }

    public void setTeamAddress(String teamAddress) {
        this.teamAddress = teamAddress;
    }
}
