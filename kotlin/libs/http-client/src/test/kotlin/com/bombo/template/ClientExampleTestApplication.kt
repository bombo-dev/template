package com.bombo.template

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class ClientExampleTestApplication

fun main(args: Array<String>) {
    runApplication<ClientExampleTestApplication>(*args)
}
