package com.barbulescu.helloautoconfigure

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "hello")
@ConstructorBinding
class HelloProperties(val language: Language)

enum class Language {
    EN, DE
}