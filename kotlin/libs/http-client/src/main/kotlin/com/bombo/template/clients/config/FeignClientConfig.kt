package com.bombo.template.clients.config

import com.bombo.template.clients.HttpClientModule
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.cloud.openfeign.FeignFormatterRegistrar
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar

@Configuration
@EnableFeignClients(basePackageClasses = [HttpClientModule::class])
class FeignClientConfig {

    @Bean
    fun dateTimeFormatterRegistrar(): FeignFormatterRegistrar {
        return FeignFormatterRegistrar { registry ->
            val registrar = DateTimeFormatterRegistrar()
            registrar.setUseIsoFormat(true)
            registrar.registerFormatters(registry)
        }
    }
}
