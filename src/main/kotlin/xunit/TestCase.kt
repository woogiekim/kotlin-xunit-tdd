package xunit

import kotlin.reflect.full.declaredFunctions

open class TestCase(
    private val name: String
) {

    open fun run() {
        val function = this::class.declaredFunctions.first { it.name == this.name }

        function.call(this)
    }
}