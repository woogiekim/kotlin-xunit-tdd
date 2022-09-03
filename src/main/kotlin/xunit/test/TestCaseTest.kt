package xunit.test

import xunit.annotation.Test
import xunit.help.Assertions.assertEquals
import java.lang.AssertionError

class TestCaseTest(name: String) : TestCase(name) {

    @Test
    fun testTemplateMethod() {
        val test = WasRun("testMethod")

        val result = TestResult()
        test.run(result)

        assertEquals("setUp testMethod tearDown", test.log)
    }

    @Test
    fun testResult() {
        val test = WasRun("testMethod")

        val result = TestResult()
        test.run(result)

        assertEquals("1 run, 0 failed", result.summary())
    }

    @Test
    fun testFailedResult() {
        val test = WasRun("testBrokenMethod")

        val result = TestResult()
        test.run(result)

        assertEquals("1 run, 1 failed", result.summary())
        assertEquals("setUp tearDown", test.log)
    }

    @Test
    fun testFailedResultFormatting() {
        val result = TestResult()

        result.testStarted()
        result.testFailed()

        assertEquals("1 run, 1 failed", result.summary())
    }

    @Test
    fun testSuite() {
        val suite = TestSuite()

        suite.add(WasRun("testMethod"))
        suite.add(WasRun("testBrokenMethod"))

        val result = TestResult()
        suite.run(result)

        assertEquals("2 run, 1 failed", result.summary())
    }

    @Test
    fun testCatchSetUpError() {
        val suite = TestSuite()

        val brokenSetUp = object : TestCase("testMethod") {
            override fun setUp() {
                throw RuntimeException()
            }
        }

        suite.add(brokenSetUp)

        val result = TestResult()
        suite.run(result)

        assertEquals("0 run, 1 failed", result.summary())
    }
}
