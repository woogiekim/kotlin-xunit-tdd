package xunit.test

import xunit.help.Assertions.assertEquals

class TestCaseTest(name: String) : TestCase(name) {

    lateinit var test: TestCase

    override fun setUp() {
        test = WasRun("testMethod")
    }

    fun testRunning() {
        assertEquals(test.wasRun, false)

        test.run()

        assertEquals(test.wasRun, true)
    }

    fun testSetUp() {
        test.run()

        assertEquals(test.wasSetUp, true)
    }
}
