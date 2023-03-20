package br.com.devrodrigues.fakeragnarok.core.configuration

import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

suspend inline fun currentWazeContext(): Context = coroutineContext[Context] ?: Context()

class Context() : AbstractCoroutineContextElement(Key) {
    companion object Key : CoroutineContext.Key<Context>

    override operator fun plus(context: CoroutineContext) = when (context) {
        is Context -> Context()

        else -> super.plus(context)
    }

    operator fun plus(context: Context) = Context()
}
