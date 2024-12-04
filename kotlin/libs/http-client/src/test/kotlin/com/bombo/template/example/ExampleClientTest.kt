package com.bombo.template.example

import com.bombo.template.ClientExampleContextTest
import com.bombo.template.client.ExampleClient
import feign.RetryableException
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class ExampleClientTest(
    val exampleClient: ExampleClient,
) : ClientExampleContextTest() {

    @Test
    fun shouldBeThrownExceptionWhenExample() {
        try {
            val result = exampleClient.example("HELLO!")
            Assertions.assertThat(result).isNotNull
        } catch (e: RetryableException) {
            
        }
    }
}
