package br.com.devrodrigues.fakeragnarok.core.configuration

import br.com.devrodrigues.fakeragnarok.application.http.handler.dto.ErrorResponse
import br.com.devrodrigues.fakeragnarok.core.domain.exceptions.Exceptions
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait

suspend fun Throwable.toServerResponse(): ServerResponse {
    val (statusCode, response) = toResponse()

    return ServerResponse.status(statusCode).bodyValueAndAwait(response)
}

private fun Throwable.toResponse(): Pair<HttpStatus, ErrorResponse> = when (this) {
    is Exceptions -> when (this) {
        is Exceptions.NotFoundException -> HttpStatus.NOT_FOUND to ErrorResponse(
            message = "not found",
        )
    }

    else -> {
        HttpStatus.INTERNAL_SERVER_ERROR to ErrorResponse(
            message = "Internal server error",
        )
    }
}
