package br.com.devrodrigues.fakeragnarok.core.domain

import kotlin.random.Random

abstract class Character(
    var strength: Int,
    var vitality: Int,
    var agility: Int,
    var dexterity: Int,
    var luck: Int,
    var intelligence: Int,
) {

    var level: Int = 1
        private set

    var experience: Int = 1
        private set

    var skillPoints: Int = 0
        private set

    abstract fun damage(): Int

    abstract fun life(): Int

    abstract val healthPerLevel: Int

    private fun levelUp() {
        level++
        skillPoints += 3
        vitality += healthPerLevel
        experience = 0
    }

    fun gainExperience(amount: Int) {
        var totalExperience = amount
        while (true) {
            if (hasLeveledUp(totalExperience)) {
                val experienceNeededForNextLevel = Companion.calculateExperienceForNextLevel(this)
                totalExperience -= experienceNeededForNextLevel - experience
                levelUp()
            } else {
                break
            }
        }
        experience += totalExperience
    }

    fun hasLeveledUp(totalExperience: Int): Boolean {
        val experienceNeededForNextLevel = calculateExperienceForNextLevel(this)
        return totalExperience >= experienceNeededForNextLevel - experience
    }

    fun distributePoints(attribute: String, points: Int) {
        when (attribute) {
            "strength" -> strength += points
            "vitality" -> vitality += points
            "agility" -> agility += points
            "dexterity" -> dexterity += points
            "luck" -> luck += points
            "intelligence" -> intelligence += points
        }
        skillPoints -= points
    }

    fun printAttributes() {
        println("Character Attributes:")
        for ((attribute, value) in getAttributes(this)) {
            println("$attribute: $value")
        }
    }

    companion object {
        fun getAttributes(character: Character): Map<String, Int> {
            return mapOf(
                "strength" to character.strength,
                "vitality" to character.vitality,
                "agility" to character.agility,
                "dexterity" to character.dexterity,
                "luck" to character.luck,
                "intelligence" to character.intelligence,
            )
        }

        fun calculateExperienceForNextLevel(character: Character): Int {
            return character.level * 100
        }
    }
}

class Archer(
    agility: Int,
    dexterity: Int,
    luck: Int,
) : Character(
    strength = 0,
    vitality = 0,
    agility = agility,
    dexterity = dexterity,
    luck = luck,
    intelligence = 0,
) {

    override val healthPerLevel: Int
        get() = 20

    override fun damage(): Int {
        val baseDamage = (agility + dexterity) / 2
        val criticalChance = luck * 0.1
        val isCritical = Random.nextDouble() < criticalChance
        return if (isCritical) {
            (baseDamage * 2.0).toInt()
        } else {
            baseDamage
        }
    }

    override fun life(): Int {
        val vitalityMultiplier = 5
        return (healthPerLevel + (vitality * vitalityMultiplier)) * level
    }
}

class Swordsman(
    strength: Int,
    vitality: Int,
    agility: Int,
) : Character(
    strength = strength,
    vitality = vitality,
    agility = agility,
    dexterity = 0,
    luck = 0,
    intelligence = 0,
) {

    override val healthPerLevel: Int
        get() = 10

    override fun damage(): Int {
        val baseDamage = (strength + agility) / 2
        val criticalChance = luck * 0.1
        val isCritical = Random.nextDouble() < criticalChance
        return if (isCritical) {
            (baseDamage * 2.0).toInt()
        } else {
            baseDamage
        }
    }

    override fun life(): Int {
        val vitalityMultiplier = 7
        return (healthPerLevel + (vitality * vitalityMultiplier)) * level
    }
}

class Mage(
    vitality: Int,
    agility: Int,
    intelligence: Int,
) : Character(
    strength = 0,
    vitality = vitality,
    agility = agility,
    dexterity = 0,
    luck = 0,
    intelligence = intelligence,
) {

    override val healthPerLevel: Int
        get() = 6

    override fun damage(): Int {
        val baseDamage = (intelligence + agility) / 2
        val magicalBonus = vitality * 0.1
        val totalDamage = baseDamage + baseDamage * magicalBonus
        return totalDamage.toInt()
    }

    override fun life(): Int {
        val vitalityMultiplier = 5
        return (healthPerLevel + (vitality * vitalityMultiplier)) * level
    }
}
