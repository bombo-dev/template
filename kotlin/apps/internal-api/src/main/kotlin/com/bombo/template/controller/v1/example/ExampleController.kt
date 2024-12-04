package com.bombo.template.controller.v1.example

import com.bombo.template.controller.v1.dto.ExampleCreateRequest
import com.bombo.template.usecase.example.ExampleUseCase
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import protocol.ResultResponse

@RestController
class ExampleController(
    private val exampleUseCase: ExampleUseCase
) {

    @PutMapping("/api/v1/examples", produces = ["application/json"])
    fun create(@RequestBody request: ExampleCreateRequest): ResultResponse<Long> {
        return ResultResponse.ok(exampleUseCase.create(request.toCommand()))
    }
}
