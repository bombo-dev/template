package com.bombo.template.controller.v1.dto

import com.bombo.template.usecase.example.command.ExampleCreateCommand

data class ExampleCreateRequest(
    val name: String,
) {
    fun toCommand() = ExampleCreateCommand(
        name = name,
    )
}
