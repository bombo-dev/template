package com.bombo.template

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@ConfigurationPropertiesScan
@SpringBootApplication
class TestApplication

fun main(args: Array<String>) {
    runApplication<TestApplication>(*args)
}
