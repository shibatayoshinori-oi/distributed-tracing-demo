package com.example.distributedtracingdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication
@EnableAspectJAutoProxy
class SpringBoot2B3W3cAApplication

fun main(args: Array<String>) {
	runApplication<SpringBoot2B3W3cAApplication>(*args)
}
