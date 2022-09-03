package xunit

import xunit.test.TestCaseTest

fun main() {
    TestCaseTest("testRunning").run()
    TestCaseTest("testSetUp").run()
}