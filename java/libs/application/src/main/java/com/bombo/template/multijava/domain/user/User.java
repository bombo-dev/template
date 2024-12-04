package com.bombo.template.multijava.domain.user;

public class User {
    private final Long id;
    private final String name;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
