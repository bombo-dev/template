package com.bombo.template.client

import protocol.ResultResponse

interface ExampleClient {

    fun example(exampleName: String): ResultResponse<Long>
}
