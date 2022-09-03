package xunit.test

import kotlin.reflect.full.declaredFunctions

open class TestCase(
    private val name: String
) {
    var wasRun: Boolean = false
        protected set

    var wasSetUp: Boolean = false
        protected set

    open fun setUp() {
        this.wasSetUp = true
    }

    open fun run() {
        setUp()

        val function = this::class.declaredFunctions.first { it.name == this.name }

        function.call(this)
    }
}