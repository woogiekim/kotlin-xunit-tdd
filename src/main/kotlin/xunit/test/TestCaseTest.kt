package xunit.test

import xunit.help.Assertions.assertEquals

class TestCaseTest(name: String) : TestCase(name) {

    lateinit var test: TestCase

    override fun setUp() {
        test = WasRun("testMethod")
    }

    fun testTemplateMethod() {
        test.run()

        assertEquals(true, test.wasSetUp)
        assertEquals("setUp testMethod tearDown", test.log)
    }

    fun testResult() {
        val result: TestResult = test.run()

        assertEquals("1 run, 0 failed", result.summary())
    }

    fun testFailedResult() {
        val test = WasRun("testBrokenMethod")

        val result = test.run()

        assertEquals("1 run, 1 failed", result.summary())
    }
}
