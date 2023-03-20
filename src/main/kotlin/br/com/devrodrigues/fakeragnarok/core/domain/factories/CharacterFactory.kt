package br.com.devrodrigues.fakeragnarok.core.domain.factories

import br.com.devrodrigues.fakeragnarok.core.domain.Archer
import br.com.devrodrigues.fakeragnarok.core.domain.Character
import br.com.devrodrigues.fakeragnarok.core.domain.Mage
import br.com.devrodrigues.fakeragnarok.core.domain.Swordsman
import br.com.devrodrigues.fakeragnarok.core.domain.validators.Validator

abstract class CharacterFactory(
    private val validator: Validator,
) {
    abstract fun create(): Character

    fun validation(
        strength: Int,
        vitality: Int,
        agility: Int,
        dexterity: Int,
        luck: Int,
        intelligence: Int,
    ): Boolean {
        return validator.attributes(
            strength = strength,
            vitality = vitality,
            agility = agility,
            dexterity = dexterity,
            luck = luck,
            intelligence = intelligence,
        )
    }
}

class ArcherFactory(validator: Validator) : CharacterFactory(validator) {
    override fun create(): Character {
        return Archer(
            agility = 10,
            dexterity = 10,
            luck = 10,
        )
    }
}

class MageFactory(validator: Validator) : CharacterFactory(validator) {
    override fun create(): Character {
        return Mage(
            vitality = 10,
            agility = 10,
            intelligence = 10,
        )
    }
}

class SwordsmanFactory(validator: Validator) : CharacterFactory(validator) {
    override fun create(): Character {
        return Swordsman(
            10,
            10,
            10,
        )
    }
}
