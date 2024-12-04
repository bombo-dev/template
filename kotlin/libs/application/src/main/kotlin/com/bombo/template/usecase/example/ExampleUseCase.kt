package com.bombo.template.usecase.example

import com.bombo.template.usecase.dto.ExampleDto
import com.bombo.template.usecase.example.command.ExampleCreateCommand
import com.bombo.template.usecase.example.command.ExampleUpdateCommand

interface ExampleUseCase {

    fun findExample(id: Long): ExampleDto

    fun update(command: ExampleUpdateCommand): ExampleDto

    fun create(command: ExampleCreateCommand): Long
}
