package com.barbulescu.springplayground.web

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

@WebFluxTest
@Import(RoutingConfiguration::class)
class RoutingConfigurationTest(@Autowired val client: WebTestClient) {

    @Test
    fun helloWithPathParameter() {
        client.get()
                .uri("/hello1/bom")
                .exchange()
                .expectStatus().isOk
                .expectBody<String>().isEqualTo("Hello bom! How are you?")
    }

    @Test
    fun helloWithQueryParameter() {
        client.get()
                .uri("/hello2?name=bom")
                .exchange()
                .expectStatus().isOk
                .expectBody<String>().isEqualTo("Hello bom! How are you?")
    }

    @Test
    fun helloWithMissingQueryParameter() {
        client.get()
                .uri("/hello2")
                .exchange()
                .expectStatus().isBadRequest
    }
}