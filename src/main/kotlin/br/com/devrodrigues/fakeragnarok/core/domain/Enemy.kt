package br.com.devrodrigues.fakeragnarok.core.domain

import kotlin.math.abs
import kotlin.random.Random

class Enemy(
    val life: Int,
    val position: Int
) {
    private val attackRange = 3
    private val damage = 10
    private val criticalDamage = 20
    private val lowDamage = 1

    fun canAttackPlayer(playerPosition: Int): Boolean {
        return abs(playerPosition - position) <= attackRange
    }

    fun attack(): Int {
        val diceRoll = Random.nextInt(1, 31)

        return if (diceRoll == 30) {
            criticalDamage
        } else if (diceRoll >= 25) {
            damage
        } else {
            lowDamage
        }
    }
}