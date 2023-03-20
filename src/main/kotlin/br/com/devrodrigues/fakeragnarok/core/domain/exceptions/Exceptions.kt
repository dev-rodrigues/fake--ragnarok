package br.com.devrodrigues.fakeragnarok.core.domain.exceptions

sealed class Exceptions(message: String) : Exception(message) {
    class NotFoundException(message: String) : Exceptions(message)
}
