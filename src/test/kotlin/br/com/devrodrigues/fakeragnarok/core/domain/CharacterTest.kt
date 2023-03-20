package br.com.devrodrigues.fakeragnarok.core.domain

import br.com.devrodrigues.fakeragnarok.core.domain.factories.ArcherFactory
import br.com.devrodrigues.fakeragnarok.core.domain.validators.ArcherValidator
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.system.captureStandardOut
import io.kotest.matchers.ints.shouldBeBetween
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain

class CharacterTest : DescribeSpec({

    lateinit var archer: Archer

    describe("Test Archer") {

        beforeEach {
            val factory = ArcherFactory(ArcherValidator())
            archer = factory.create() as Archer
        }

        it("should level up when enough experience is gained") {

            archer.level shouldBe 1

            archer.gainExperience(100)

            archer.level shouldBe 2

        }

        it("should update level correctly after gaining experience") {
            archer.gainExperience(300)
            archer.level shouldBe 3
        }

        it("should not level up when not enough experience is gained") {

            archer.level shouldBe 1

            archer.gainExperience(10)

            archer.level shouldBe 1
        }

        it("should distribute points correctly") {
            archer.gainExperience(100)

            archer.distributePoints("agility", 1)

            archer.agility shouldBe 11
            archer.skillPoints shouldBe 2
        }

        it("should print attributes correctly") {
            val expectedOutput =
                    "strength: 0\n" +
                    "vitality: 0\n" +
                    "agility: 10\n" +
                    "dexterity: 10\n" +
                    "luck: 10\n" +
                    "intelligence: 0\n"

            captureStandardOut {
                archer.printAttributes()
            } shouldContain expectedOutput
        }

        it("getAttributes should return attributes correctly") {
            val expectedAttributes = mapOf(
                "strength" to 0,
                "vitality" to 0,
                "agility" to 10,
                "dexterity" to 10,
                "luck" to 10,
                "intelligence" to 0,
            )
            Character.getAttributes(archer) shouldBe expectedAttributes
        }

        it("should calculate damage correctly") {
            val damage = archer.damage()

            damage.shouldBeBetween(10, 20)
        }

        it("life should be calculated correctly") {
            val expectedLife = (20 + (archer.vitality * 5)) * archer.level

            archer.life() shouldBe expectedLife
        }

        it("should calculate experience for next level correctly") {
            Character.calculateExperienceForNextLevel(archer) shouldBe 100
        }

        it("should return true when has leveled up") {

            archer.hasLeveledUp(100) shouldBe true
        }
    }
})