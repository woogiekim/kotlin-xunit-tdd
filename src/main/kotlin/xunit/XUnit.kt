package xunit

import xunit.test.TestCaseTest

fun main() {
    TestCaseTest("testTemplateMethod").run()
    TestCaseTest("testResult").run()
    TestCaseTest("testFailedResult").run()
}
