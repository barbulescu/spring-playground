package com.barbulescu.springplayground.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.BodyInserters.fromValue
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono

@Configuration
@EnableWebFlux
class RoutingConfiguration {

    @Bean
    fun router(helloHandler: HelloHandler) = router {
        GET("/hello/{name}", helloHandler::hello)
    }

    @Bean
    fun helloHandler() = HelloHandler()

    class HelloHandler {
        fun hello(request: ServerRequest): Mono<ServerResponse> {
            val name = request.pathVariable("name")
            return ServerResponse.ok().body(fromValue("Hello $name! How are you?"))
        }
    }
}