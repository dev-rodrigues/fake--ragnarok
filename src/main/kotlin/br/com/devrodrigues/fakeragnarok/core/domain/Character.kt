package br.com.devrodrigues.fakeragnarok.core.domain

open class Character(
    var strength: Int,
    var vitality: Int,
    var agility: Int,
    var dexterity: Int,
    var luck: Int,
    var intelligence: Int
)

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
    intelligence = 0
)

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
    intelligence = 0
)

class Mage(
    vitality: Int,
    agility: Int,
    intelligence: Int
) : Character(
    strength = 0,
    vitality = vitality,
    agility = agility,
    dexterity = 0,
    luck = 0,
    intelligence = intelligence
)