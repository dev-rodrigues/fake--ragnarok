package br.com.devrodrigues.fakeragnarok.core.domain.validators

abstract class Validator {
    abstract fun attributes(
        strength: Int,
        vitality: Int,
        agility: Int,
        dexterity: Int,
        luck: Int,
        intelligence: Int,
    ): Boolean
}

class ArcherValidator : Validator() {
    override fun attributes(
        strength: Int,
        vitality: Int,
        agility: Int,
        dexterity: Int,
        luck: Int,
        intelligence: Int,
    ): Boolean {
        TODO("Not yet implemented")
    }
}

class MageValidator : Validator() {
    override fun attributes(
        strength: Int,
        vitality: Int,
        agility: Int,
        dexterity: Int,
        luck: Int,
        intelligence: Int,
    ): Boolean {
        TODO("Not yet implemented")
    }
}

class SwordsmanValidator : Validator() {
    override fun attributes(
        strength: Int,
        vitality: Int,
        agility: Int,
        dexterity: Int,
        luck: Int,
        intelligence: Int,
    ): Boolean {
        TODO("Not yet implemented")
    }
}
