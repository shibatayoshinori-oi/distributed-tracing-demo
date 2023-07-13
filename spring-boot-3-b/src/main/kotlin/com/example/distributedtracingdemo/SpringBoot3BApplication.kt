package com.example.distributedtracingdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication
@EnableAspectJAutoProxy
class SpringBoot3BApplication

fun main(args: Array<String>) {
	runApplication<SpringBoot3BApplication>(*args)
}
