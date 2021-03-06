package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@MicronautTest
class ExampleControllerTest {

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    void expectedBadRequest() {
        var e = assertThrows(HttpClientResponseException.class, () ->
            httpClient.toBlocking().exchange(HttpRequest.POST("/", "foo")));
        assertEquals(HttpStatus.BAD_REQUEST, e.getStatus());
    }

    @Test
    void unexpectedInternalServerError() {
        var e = assertThrows(HttpClientResponseException.class, () ->
            httpClient.toBlocking().exchange(HttpRequest.POST("/", "")));
        assertEquals(HttpStatus.BAD_REQUEST, e.getStatus());
    }
}
