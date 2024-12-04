package com.bombo.template.multijava.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.ZonedDateTime;

@MappedSuperclass
public class BaseTimeEntity {

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private ZonedDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private ZonedDateTime modifiedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = ZonedDateTime.now(); // common module 분리
        modifiedAt = ZonedDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedAt = ZonedDateTime.now();
    }
}
