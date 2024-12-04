package com.bombo.template

import com.bombo.template.domain.example.ExampleRepository
import com.bombo.template.service.ExampleService
import org.junit.jupiter.api.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.transaction.annotation.Transactional

@ActiveProfiles("local")
@Tag("context")
@Transactional
@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
abstract class ApplicationContextTest {

    @Autowired
    protected lateinit var exampleService: ExampleService

    @Autowired
    protected lateinit var exampleRepository: ExampleRepository
}
