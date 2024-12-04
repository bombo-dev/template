package com.bombo.template.persistence.example

import com.bombo.template.domain.example.Example
import com.bombo.template.domain.example.ExampleRepository
import org.springframework.stereotype.Repository

@Repository
class ExampleEntityRepository(
    private val exampleJpaRepository: ExampleJpaRepository
) : ExampleRepository {

    override fun save(example: Example): Long {
        return exampleJpaRepository.save(ExampleMapper.toEntity(example)).id
    }

    override fun findById(id: Long): Example? {
        return exampleJpaRepository.findById(id)
            .map { ExampleMapper.toDomain(it) }
            .orElse(null)
    }
}
