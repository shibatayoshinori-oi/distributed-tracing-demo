package com.example.distributedtracingdemo

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class LoggingAspect {

    private val logger: Logger = LoggerFactory.getLogger(LoggingAspect::class.java)

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    fun getMapping(joinPoint: JoinPoint) {
        logger.info("Controller method [${joinPoint.signature.name}] called")
    }
}