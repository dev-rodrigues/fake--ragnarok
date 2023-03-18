package br.com.devrodrigues.fakeragnarok.application.http.handler

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

@Component
class ClassesApi {

    suspend fun get(request: ServerRequest): ServerResponse {
        return ServerResponse.ok().bodyValueAndAwait(
            body = "ok"
        )
    }
}