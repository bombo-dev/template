package com.bombo.template.configure

import com.bombo.template.persistence.PersistenceModule
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EntityScan(basePackageClasses = [PersistenceModule::class])
@EnableJpaRepositories(basePackageClasses = [PersistenceModule::class])
class PersistenceJpaConfig
