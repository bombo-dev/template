package com.bombo.template.configure

import com.zaxxer.hikari.HikariDataSource
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

@Configuration
internal class PersistenceDataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    fun dataSourceProperties() = DataSourceProperties()

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    fun dataSource(dataSourceProperties: DataSourceProperties): HikariDataSource =
        dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource::class.java).build()
}
