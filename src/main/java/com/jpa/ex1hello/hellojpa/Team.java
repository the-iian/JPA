package com.jpa.ex1hello.hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team") // 일대다 맵핑에서 어떤거랑 연결되어있는지 주인 지정
    private List<Member> members = new ArrayList<>();

    /* 연관관계 편의 메소드2 양쪽 하나만 사용하면 됨
    public void addMember(Member member){
        member.setTeam(this);
        members.add(member);
    } */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
