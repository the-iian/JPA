package com.jpa.ex1hello.hellojpa;

import javax.persistence.*;

@Entity // JPA가 관리하는 엔티티. 옵션-(name="") JPA가 내부적으로 구분하는 이름
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME") // DB 컬럼명은 다른거로 쓰고싶을 때
    private String username;

    @Column(name = "TEAM_ID")
    private Long teamId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}

