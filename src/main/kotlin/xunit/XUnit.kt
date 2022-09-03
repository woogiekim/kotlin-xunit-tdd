package xunit

import xunit.test.TestCaseTest
import xunit.test.TestResult

fun main() {
    val suite = TestCaseTest.suite()

    val result = TestResult()
    suite.run(result)

    println(result.summary())
}
