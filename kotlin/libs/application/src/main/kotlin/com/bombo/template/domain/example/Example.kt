package com.bombo.template.domain.example

class Example(
    id: Long = 0,
    name: String,
) {
    val id: Long = id
    var name: String = name
        protected set

    companion object {
        fun newInstance(name: String): Example {
            return Example(name = name)
        }
    }

    fun changeName(name: String) {
        this.name = name
    }
}
