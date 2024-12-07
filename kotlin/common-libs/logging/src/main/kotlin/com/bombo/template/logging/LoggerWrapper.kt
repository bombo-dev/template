package com.bombo.template.logging

import org.slf4j.Logger

class LoggerWrapper(
    private val logger: Logger
) {
    fun info(message: String) {
        if (logger.isInfoEnabled) {
            logger.info(message)
        }
    }

    fun info(callMessage: () -> Any?) {
        if (logger.isInfoEnabled) {
            logger.info(callMessage().toString())
        }
    }

    fun info(t: Throwable, callMessage: () -> Any?) {
        if (logger.isInfoEnabled) {
            logger.info(callMessage().toString(), t)
        }
    }

    fun debug(message: String) {
        if (logger.isDebugEnabled) {
            logger.debug(message)
        }
    }

    fun debug(callMessage: () -> Any?) {
        if (logger.isDebugEnabled) {
            logger.debug(callMessage().toString())
        }
    }

    fun debug(t: Throwable, callMessage: () -> Any?) {
        if (logger.isDebugEnabled) {
            logger.debug(callMessage().toString(), t)
        }
    }

    fun warn(message: String) {
        if (logger.isWarnEnabled) {
            logger.warn(message)
        }
    }

    fun warn(callMessage: () -> Any?) {
        if (logger.isWarnEnabled) {
            logger.warn(callMessage().toString())
        }
    }

    fun warn(t: Throwable, callMessage: () -> Any?) {
        if (logger.isWarnEnabled) {
            logger.warn(callMessage().toString(), t)
        }
    }

    fun error(message: String) {
        logger.error(message)
    }

    fun error(callMessage: () -> Any?) {
        logger.error(callMessage().toString())
    }

    fun error(t: Throwable, callMessage: () -> Any?) {
        logger.error(callMessage().toString(), t)
    }
}
