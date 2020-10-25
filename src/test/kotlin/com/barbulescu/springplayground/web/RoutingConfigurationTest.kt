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
    fun router() {
        client.get()
                .uri("/hello/bom")
                .exchange()
                .expectStatus().isOk
                .expectBody<String>().isEqualTo("Hello bom! How are you?")
    }
}