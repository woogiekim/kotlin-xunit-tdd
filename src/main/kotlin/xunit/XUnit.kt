package xunit

import xunit.test.TestCaseTest
import xunit.test.TestResult
import xunit.test.TestSuite

fun main() {
    val suite = TestSuite()

    suite.add(TestCaseTest("testTemplateMethod"))
    suite.add(TestCaseTest("testResult"))
    suite.add(TestCaseTest("testFailedResult"))
    suite.add(TestCaseTest("testFailedResultFormatting"))
    suite.add(TestCaseTest("testSuite"))

    val result = TestResult()
    suite.run(result)

    println(result.summary())
}
