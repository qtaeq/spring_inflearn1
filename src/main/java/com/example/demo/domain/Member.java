package com.example.demo.domain;

import javax.persistence.*;

@Entity // JPA
public class Member {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) // Key값 관련련, JPA
    private Long id;
    @Column(name="name")    // 컬럼 이름과 매핑, JPA
    private String name;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
