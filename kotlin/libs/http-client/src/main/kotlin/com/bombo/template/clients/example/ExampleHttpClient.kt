package com.bombo.template.clients.example

import com.bombo.template.client.ExampleClient
import com.bombo.template.clients.example.model.ExampleRequest
import org.springframework.stereotype.Component
import protocol.ResultResponse

@Component
class ExampleHttpClient(
    private val exampleApi: ExampleApi,
) : ExampleClient {
    override fun example(name: String): ResultResponse<Long> {
        val request = ExampleRequest(name)
        return exampleApi.example(request)
    }
}
