package br.com.devrodrigues.fakeragnarok.application.http

import br.com.devrodrigues.fakeragnarok.application.http.handler.ClassesApi
import br.com.devrodrigues.fakeragnarok.core.configuration.toServerResponse
import br.com.devrodrigues.fakeragnarok.core.configuration.withRequestContext
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.server.coRouter

@RestController
class Router(
    private val api: ClassesApi,
) {

    companion object {
        const val CLASSES_PATH = "/classes"
    }

    @Bean
    fun requestRouter() = coRouter {
        onError<Throwable> { ex, _ ->
            withRequestContext {
                ex.toServerResponse()
            }
        }
        accept(MediaType.APPLICATION_JSON).nest {
            CLASSES_PATH.nest {
                GET("/") { request ->
                    withRequestContext {
                        api.get(request)
                    }
                }
            }
        }
    }
}