package br.com.devrodrigues.fakeragnarok.core.domain

import kotlin.concurrent.thread

abstract class MapGame {
    companion object {
        const val SPOT = "S"
        const val ATTACK_TOWER = "Ta"
        const val DEFENSE_TOWER = "Td"
        const val INTERVAL_GENERATE_ENEMIES = 50L
    }

    init {
        startEnemyGeneration()
    }

    abstract var towers: List<Tower>
    abstract var spots: List<Enemy>
    abstract fun buildMap()
    abstract fun printMap()
    abstract fun generateEnemies()
    abstract fun hasCharacter(character:Character): Boolean
    abstract fun getCharacterPosition(character: Character): Int
    abstract fun isAdjacent(characterPosition: Int, enemyPosition: Int): Boolean
    abstract fun getValidMoves(currentPosition: Int): List<Int>
    abstract fun move(currentPosition: Int, direction: Int): Int
    abstract fun moveCharacter(character: Character, newPosition: Int)

    private fun startEnemyGeneration() {
        thread(start = true) {
            while (true) {
                Thread.sleep(INTERVAL_GENERATE_ENEMIES)
                if (spots.isEmpty()) {
                    generateEnemies()
                }
            }
        }
    }


}