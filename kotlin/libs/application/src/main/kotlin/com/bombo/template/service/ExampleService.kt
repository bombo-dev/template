package com.bombo.template.service

import com.bombo.template.domain.example.Example
import com.bombo.template.domain.example.ExampleRepository
import com.bombo.template.usecase.dto.ExampleDto
import com.bombo.template.usecase.example.ExampleUseCase
import com.bombo.template.usecase.example.command.ExampleCreateCommand
import com.bombo.template.usecase.example.command.ExampleUpdateCommand
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class ExampleService(
    private val exampleRepository: ExampleRepository,
) : ExampleUseCase {

    override fun findExample(id: Long): ExampleDto {
        val example = exampleRepository.findById(id) ?: throw IllegalArgumentException("Example not found")
        return ExampleDto(example.name)
    }

    @Transactional
    override fun update(command: ExampleUpdateCommand): ExampleDto {
        val example = exampleRepository.findById(command.id) ?: throw IllegalArgumentException("Example not found")
        example.changeName(command.name)
        exampleRepository.save(example)

        return ExampleDto(example.name)
    }

    override fun create(command: ExampleCreateCommand): Long {
        val newExample = Example.newInstance(command.name)
        val savedId = exampleRepository.save(newExample)

        return savedId
    }
}
