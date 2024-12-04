package com.bombo.template.multijava.persistence.user;

import com.bombo.template.multijava.persistence.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    protected UserEntity() {
    }

    private UserEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static UserEntity newInstance(Long id, String name) {
        return new UserEntity(id, name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
