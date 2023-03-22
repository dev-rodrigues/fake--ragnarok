package br.com.devrodrigues.fakeragnarok.core.domain

class Tower(
    val type: String, //ATTACK_TOWER || DEFENSE_TOWER
    val position: Int,
    val life: Int
)