package com.barbulescu.helloautoconfigure

import com.barbulescu.helloautoconfigure.Language.DE
import com.barbulescu.helloautoconfigure.Language.EN

class HelloService(private val language: Language) {
    fun sayHello(name: String): String {
        return when (language) {
            EN -> "Hello $name"
            DE -> "Hallo $name"
        }
    }
}