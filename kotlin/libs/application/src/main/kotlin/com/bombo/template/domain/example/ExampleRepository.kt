package com.bombo.template.domain.example

interface ExampleRepository {

    fun save(example: Example): Long

    fun findById(id: Long): Example?
}
