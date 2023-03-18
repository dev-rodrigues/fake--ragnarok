package br.com.devrodrigues.fakeragnarok.core.domain.usecases

import br.com.devrodrigues.fakeragnarok.core.domain.Archer
import br.com.devrodrigues.fakeragnarok.core.domain.Mage
import br.com.devrodrigues.fakeragnarok.core.domain.Swordsman
import br.com.devrodrigues.fakeragnarok.core.domain.factories.ArcherFactory
import br.com.devrodrigues.fakeragnarok.core.domain.factories.MageFactory
import br.com.devrodrigues.fakeragnarok.core.domain.factories.SwordsmanFactory
import br.com.devrodrigues.fakeragnarok.core.domain.validators.ArcherValidator
import br.com.devrodrigues.fakeragnarok.core.domain.validators.MageValidator
import br.com.devrodrigues.fakeragnarok.core.domain.validators.SwordsmanValidator
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.types.shouldBeInstanceOf

class FakeTest : DescribeSpec({
    describe("Create Characters") {
        it("Should create Archer using factory") {
            val factory = ArcherFactory(ArcherValidator())
            val character = factory.create()

            character.shouldBeInstanceOf<Archer>()
        }

        it("Should create Mage using factory") {
            val factory = MageFactory(MageValidator())
            val character = factory.create()

            character.shouldBeInstanceOf<Mage>()
        }

        it("Should Swordsman Mage using factory") {
            val factory = SwordsmanFactory(SwordsmanValidator())
            val character = factory.create()

            character.shouldBeInstanceOf<Swordsman>()
        }
    }
})