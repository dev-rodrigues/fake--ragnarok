package br.com.devrodrigues.fakeragnarok

import br.com.devrodrigues.fakeragnarok.application.Game
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FakeRagnarokApplication : CommandLineRunner {
    override fun run(vararg args: String?) {
        Game()
    }
}

fun main(args: Array<String>) {
    runApplication<FakeRagnarokApplication>(*args)
}
