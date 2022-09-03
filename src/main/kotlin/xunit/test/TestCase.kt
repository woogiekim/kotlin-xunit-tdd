package xunit.test

import kotlin.reflect.full.declaredFunctions

open class TestCase(
    private val name: String
) {
    var log: String = ""
        protected set

    var wasRun: Boolean = false
        protected set

    var wasSetUp: Boolean = false
        protected set

    var wasTearDown: Boolean = false
        protected set

    open fun setUp() {
        this.wasSetUp = true
        this.log = "setUp"
    }

    open fun tearDown() {
        this.wasTearDown = true
        this.log += " tearDown"
    }

    open fun run(result: TestResult) {
        result.testStarted()

        setUp()

        try {
            val function = this::class.declaredFunctions.first { it.name == this.name }

            function.call(this)
        } catch (e: Exception) {
            result.testFailed()
        } finally {
            tearDown()
        }
    }
}