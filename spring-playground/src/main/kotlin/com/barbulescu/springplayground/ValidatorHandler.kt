package com.barbulescu.springplayground

import org.springframework.stereotype.Component

@Component
class ValidatorHandler(val validators:List<Validator>) {
    init {
        println("Received ${validators.size} validators")
    }
}

interface Validator

@Component
class StringValidator:Validator

@Component
class IntegerValidator:Validator