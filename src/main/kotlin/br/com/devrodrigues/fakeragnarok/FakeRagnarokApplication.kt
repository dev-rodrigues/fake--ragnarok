package br.com.devrodrigues.fakeragnarok

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FakeRagnarokApplication

fun main(args: Array<String>) {
    runApplication<FakeRagnarokApplication>(*args)
}
