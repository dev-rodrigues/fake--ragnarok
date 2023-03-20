package br.com.devrodrigues.fakeragnarok.core.configuration

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.slf4j.MDCContext
import kotlinx.coroutines.withContext
import org.springframework.web.reactive.function.server.ServerResponse

suspend inline fun withRequestContext(
    noinline block: suspend CoroutineScope.(Context) -> ServerResponse,
): ServerResponse {
    val context = currentWazeContext()

    return withContext(context + MDCContext()) {
        try {
            block(context)
        } catch (ex: Throwable) {
            ex.toServerResponse()
        }
    }
}
