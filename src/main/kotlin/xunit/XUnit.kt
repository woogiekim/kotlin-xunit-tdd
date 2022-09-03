package xunit

import xunit.test.TestCaseTest
import xunit.test.TestResult
import xunit.test.TestSuite

fun main() {
    val suite = TestSuite.suite(TestCaseTest::class)
    val suite2 = TestSuite.suite(TestCaseTest::class)

    val result = TestResult()

    suite.add(suite2)

    suite.run(result)

    println(result.summary())
}
