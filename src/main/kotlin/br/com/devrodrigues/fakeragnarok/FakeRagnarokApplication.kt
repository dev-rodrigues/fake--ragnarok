package br.com.devrodrigues.fakeragnarok

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FakeRagnarokApplication : CommandLineRunner {
    override fun run(vararg args: String?) {

    }
}

fun main(args: Array<String>){
    runApplication<FakeRagnarokApplication>(*args)
}