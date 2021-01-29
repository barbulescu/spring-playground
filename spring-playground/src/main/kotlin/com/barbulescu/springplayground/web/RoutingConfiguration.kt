package com.barbulescu.springplayground.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.BodyInserters.fromValue
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import org.springframework.web.server.ServerWebInputException
import reactor.core.publisher.Mono

@Configuration
@EnableWebFlux
class RoutingConfiguration {

    @Bean
    fun router(helloHandler: HelloHandler) = router {
        GET("/hello1/{name}", helloHandler::hello1)
        GET("/hello2", helloHandler::hello2)
    }

    @Bean
    fun helloHandler() = HelloHandler()

    class HelloHandler {
        fun hello1(request: ServerRequest): Mono<ServerResponse> =
                sayHello(request.pathVariable("name"))

        fun hello2(request: ServerRequest): Mono<ServerResponse> =
                sayHello(request.queryParam("name")
                        .orElseThrow { ServerWebInputException("Query parameter 'name' not found!") })

        private fun sayHello(name: String?): Mono<ServerResponse> =
                ServerResponse.ok().body(fromValue("Hello $name! How are you?"))
    }
}