package com.bombo.template.logging

import org.slf4j.LoggerFactory

fun logger(name: String): SimpleLogger = SimpleLogger(LoggerFactory.getLogger(name))

inline fun <reified T : Any> T.log(): SimpleLogger = logger(T::class.java.name)
