package xunit.test

import xunit.help.Assertions.assertEquals

class TestCaseTest(name: String) : TestCase(name) {

    fun testRunning() {
        val test = WasRun("testMethod")

        assertEquals(test.wasRun, false)

        test.run()

        assertEquals(test.wasRun, true)
    }
}
