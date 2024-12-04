package com.bombo.template.configure

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import javax.sql.DataSource

@Configuration
class PersistenceJdbcConfig {

    @Bean
    @Primary
    fun jdbcTemplate(dataSource: DataSource) = JdbcTemplate(dataSource)

    @Bean
    @Primary
    fun namedParameterJdbcTemplate(jdbcTemplate: JdbcTemplate) = NamedParameterJdbcTemplate(jdbcTemplate)
}
