package br.com.devrodrigues.fakeragnarok.application

import br.com.devrodrigues.fakeragnarok.core.domain.maps.SummonerRiftMap

class Game {
    private val map = SummonerRiftMap()

    init {
        println("Welcome to Summoner's Rift!")

        println("Loading map...")
        map.buildMap()

        Thread.sleep(1000)
        clearConsole()

        map.printMap()

        var input: String
        while (true) {
            println("What would you like to do?")
            println("1. Generate more enemies")
            println("2. Attack enemies")
            println("3. Quit game")

            input = readlnOrNull() ?: ""

            when (input) {
                "1" -> {
                    map.generateEnemies()
                    clearConsole()
                    map.printMap()
                }
                "2" -> {
                    // implement attack logic
                }
                "3" -> {
                    println("Exiting game...")
                    break
                }
                else -> {
                    println("Invalid input. Please try again.")
                }
            }
            clearConsole()
        }
    }
}

fun clearConsole() {
    if (System.getProperty("os.name").contains("Windows")) {
        Runtime.getRuntime().exec("cmd /c cls")
    } else {
        Runtime.getRuntime().exec("clear")
    }
}