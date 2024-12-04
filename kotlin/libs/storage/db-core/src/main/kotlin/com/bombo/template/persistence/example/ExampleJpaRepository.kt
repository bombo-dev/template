package com.bombo.template.persistence.example

import org.springframework.data.jpa.repository.JpaRepository

interface ExampleJpaRepository : JpaRepository<ExampleEntity, Long> {

}
