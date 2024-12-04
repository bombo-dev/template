package com.bombo.template.persistence.example

import com.bombo.template.domain.example.Example

class ExampleMapper {

    companion object {
        fun toEntity(domain: Example): ExampleEntity {
            return ExampleEntity(
                id = domain.id,
                name = domain.name,
            )
        }

        fun toDomain(entity: ExampleEntity): Example {
            return Example(
                id = entity.id,
                name = entity.name,
            )
        }
    }
}
