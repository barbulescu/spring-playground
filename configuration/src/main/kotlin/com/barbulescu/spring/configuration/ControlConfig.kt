package com.barbulescu.spring.configuration

import org.springframework.boot.context.properties.bind.Binder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

@Configuration
class ControlConfig(val env: Environment) {
    @Bean
    fun controlFlow(): Flow = Binder.get(env).bind("control", Flow::class.java).get()

    @Bean
    fun controlFlowExecutor(): FlowExecutor {
        return FlowExecutor(controlFlow())
    }

}