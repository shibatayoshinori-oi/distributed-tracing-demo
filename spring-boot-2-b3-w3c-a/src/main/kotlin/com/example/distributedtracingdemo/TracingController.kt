package com.example.distributedtracingdemo

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.http.HttpServletRequest

@Controller
class TracingController(
        private val restTemplateBuilder: RestTemplateBuilder
) {

    private val logger: Logger = LoggerFactory.getLogger(TracingController::class.java)

    @GetMapping("/")
    fun home(request: HttpServletRequest): String {
        logRequestHeaders(request)
        return "home"
    }

    @GetMapping("/direct")
    fun direct(
            request: HttpServletRequest,
            model: Model
    ): String {
        logRequestHeaders(request)
        bindIds(model)
        bindHeaders(request, model)
        return "direct"
    }

    @GetMapping("/call-sb2-b3")
    fun callSpringBoot2B3(
            request: HttpServletRequest,
            model: Model
    ): String {
        logRequestHeaders(request)
        callApi("http://localhost:8081/")
        bindIds(model)
        bindHeaders(request, model)
        return "call-sb2-b3-w3c"
    }

    @GetMapping("/call-sb2-b3-w3c")
    fun callSpringBoot2B3W3c(
            request: HttpServletRequest,
            model: Model
    ): String {
        logRequestHeaders(request)
        callApi("http://localhost:8083/")
        bindIds(model)
        bindHeaders(request, model)
        return "call-sb2-b3-w3c"
    }

    @GetMapping("/call-sb3")
    fun callSpringBoot3(
            request: HttpServletRequest,
            model: Model
    ): String {
        logRequestHeaders(request)
        callApi("http://localhost:8084/")
        bindIds(model)
        bindHeaders(request, model)
        return "call-sb3"
    }

    private fun logRequestHeaders(request: HttpServletRequest) {
        logger.info("Request headers: ${request.headerNames.toList().associateWith { request.getHeader(it) }}")
    }

    private fun bindIds(model: Model) {
        model["traceId"] = MDC.get("traceId")
        model["spanId"] = MDC.get("spanId")
    }

    private fun bindHeaders(request: HttpServletRequest, model: Model) {
        model["headers"] = request.headerNames.toList().associateWith { request.getHeader(it) }
    }

    private fun callApi(url: String) {
        restTemplateBuilder.build().getForObject(url, String::class.java)
    }
}