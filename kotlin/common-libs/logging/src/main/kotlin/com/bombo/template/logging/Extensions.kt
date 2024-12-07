package com.bombo.template.logging

import org.slf4j.LoggerFactory

fun logger(name: String): LoggerWrapper = LoggerWrapper(LoggerFactory.getLogger(name))

inline fun <reified T : Any> T.log(): LoggerWrapper = logger(T::class.java.name)
