package xunit

import xunit.test.TestCaseTest
import xunit.test.TestResult
import xunit.test.TestSuite.Companion.suite

fun main() {
    val suite = suite(TestCaseTest::class)

    val result = TestResult()

    suite.run(result)

    println(result.summary())
}
