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
}
