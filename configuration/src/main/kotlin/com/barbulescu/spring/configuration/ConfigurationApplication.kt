package com.barbulescu.spring.configuration

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class ConfigurationApplication

@Component
class ApplicationInitializer(val controlFlow: Flow, val baselineFlow: Flow) : ApplicationRunner {
    override fun run(args: ApplicationArguments) {
        println("Control flow: $controlFlow")
        println("Baseline flow: $baselineFlow")
    }
}

fun main(args: Array<String>) {
    runApplication<ConfigurationApplication>(*args)
}
