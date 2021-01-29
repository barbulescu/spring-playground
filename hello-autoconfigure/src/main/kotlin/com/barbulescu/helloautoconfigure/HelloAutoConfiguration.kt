package com.barbulescu.helloautoconfigure

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@ConditionalOnProperty("hello.language")
@EnableConfigurationProperties(value = [HelloProperties::class])
class HelloAutoConfiguration(val properties: HelloProperties) {

    @Bean
    @ConditionalOnMissingBean
    fun helloService() = HelloService(properties.language)
}