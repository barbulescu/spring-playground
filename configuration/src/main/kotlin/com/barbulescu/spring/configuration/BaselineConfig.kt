package com.barbulescu.spring.configuration

import org.springframework.boot.context.properties.bind.Binder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

@Configuration
class BaselineConfig(val env:Environment) {
    @Bean
    fun baselineFlow(): Flow = Binder.get(env).bind("baseline", Flow::class.java).get()

    @Bean
    fun baselineFlowExecutor():FlowExecutor {
        return FlowExecutor(baselineFlow())
    }

}