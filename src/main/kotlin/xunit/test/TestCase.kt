package xunit.test

import kotlin.Exception
import kotlin.reflect.full.declaredFunctions

open class TestCase(
    private val name: String
) : Test {
    var log: String = ""
        protected set

    open fun setUp() {
        this.log = "setUp"
    }

    open fun tearDown() {
        this.log += " tearDown"
    }

    override fun run(result: TestResult) {
        try {
            try {
                setUp()
            } catch (e: Exception) {
                throw RuntimeException()
            }

            result.testStarted()

            val function = this::class.declaredFunctions.first { it.name == this.name }

            function.call(this)
        } catch (e: Exception) {
            result.testFailed()
        } finally {
            tearDown()
        }
    }
}