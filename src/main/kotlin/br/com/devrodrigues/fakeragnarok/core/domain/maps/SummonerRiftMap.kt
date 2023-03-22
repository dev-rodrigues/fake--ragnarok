package br.com.devrodrigues.fakeragnarok.core.domain.maps

import br.com.devrodrigues.fakeragnarok.core.domain.Character
import br.com.devrodrigues.fakeragnarok.core.domain.Enemy
import br.com.devrodrigues.fakeragnarok.core.domain.MapGame
import br.com.devrodrigues.fakeragnarok.core.domain.Tower

class SummonerRiftMap : MapGame() {

    override var towers: List<Tower> = mutableListOf()
    override var spots: List<Enemy> = mutableListOf()

    private val map = arrayOf(
        arrayOf("", "", "", "", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", "", "", "", ""),
    )

    override fun buildMap() {
        for (i in map.indices) {
            for (j in map[i].indices) {
                if (i == 0 && j % 2 == 0) {
                    towers += Tower(ATTACK_TOWER, j, 100)
                    map[i][j] = ATTACK_TOWER
                } else if (i == 9) {
                    towers += Tower(DEFENSE_TOWER, j, 100)
                    map[i][j] = DEFENSE_TOWER
                } else if (i == 4 && j == 4) {
                    spots += Enemy(100, j)
                    map[i][j] = SPOT
                }
            }
        }
    }

    override fun printMap() {
        // Imprime os números das colunas
        println("  0  1  2  3  4  5  6  7  8  9")

        for (i in map.indices) {
            print("$i ")

            for (j in map[i].indices) {
                print(map[i][j].padEnd(3))
            }
            println()
        }
    }

    override fun generateEnemies() {
        //spots.plus(Enemy(100, 4))
    }

    override fun hasCharacter(character: Character): Boolean {
        TODO("Not yet implemented")
    }

    override fun getCharacterPosition(character: Character): Int {
        TODO("Not yet implemented")
    }

    override fun isAdjacent(characterPosition: Int, enemyPosition: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun getValidMoves(currentPosition: Int): List<Int> {
        TODO("Not yet implemented")
    }

    override fun move(currentPosition: Int, direction: Int): Int {
        TODO("Not yet implemented")
    }

    override fun moveCharacter(character: Character, newPosition: Int) {
        TODO("Not yet implemented")
    }
}