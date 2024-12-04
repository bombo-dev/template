package com.bombo.template.persistence

import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import time.DateTimeUtils
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {

    @CreationTimestamp
    val createdAt: LocalDateTime = DateTimeUtils.now().toLocalDateTime()

    @UpdateTimestamp
    val updatedAt: LocalDateTime = DateTimeUtils.now().toLocalDateTime()
}
