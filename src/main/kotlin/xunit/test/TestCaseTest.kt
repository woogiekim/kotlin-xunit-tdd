package xunit.test

import xunit.help.Assertions.assertEquals

class TestCaseTest(name: String) : TestCase(name) {

    lateinit var test: TestCase

    companion object {
        fun suite(): TestSuite {
            val suite = TestSuite()

            suite.add(TestCaseTest("testTemplateMethod"))
            suite.add(TestCaseTest("testResult"))
            suite.add(TestCaseTest("testFailedResult"))
            suite.add(TestCaseTest("testFailedResultFormatting"))
            suite.add(TestCaseTest("testSuite"))

            return suite
        }
    }

    override fun setUp() {
        test = WasRun("testMethod")
    }

    fun testTemplateMethod() {
        val result = TestResult()
        test.run(result)

        assertEquals(true, test.wasSetUp)
        assertEquals("setUp testMethod tearDown", test.log)
    }

    fun testResult() {
        val result = TestResult()
        test.run(result)

        assertEquals("1 run, 0 failed", result.summary())
    }

    fun testFailedResult() {
        val test = WasRun("testBrokenMethod")

        val result = TestResult()
        test.run(result)

        assertEquals("1 run, 1 failed", result.summary())
    }

    fun testFailedResultFormatting() {
        val result = TestResult()

        result.testStarted()
        result.testFailed()

        assertEquals("1 run, 1 failed", result.summary())
    }

    fun testSuite() {
        val suite = TestSuite()

        suite.add(WasRun("testMethod"))
        suite.add(WasRun("testBrokenMethod"))

        val result = TestResult()
        suite.run(result)

        assertEquals("2 run, 1 failed", result.summary())
    }


}
