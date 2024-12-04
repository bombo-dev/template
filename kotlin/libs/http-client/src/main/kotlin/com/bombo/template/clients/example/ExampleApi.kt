package com.bombo.template.clients.example

import com.bombo.template.clients.example.model.ExampleRequest
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import protocol.ResultResponse

@FeignClient(value = "ExampleOpenFeign", url = "\${example.api.url}")
interface ExampleApi {

    @RequestMapping(
        method = [RequestMethod.PUT],
        value = ["/api/v1/examples"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
    )
    fun example(@RequestBody request: ExampleRequest): ResultResponse<Long>
}
