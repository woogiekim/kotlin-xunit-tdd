package xunit

import xunit.test.TestCaseTest
import xunit.test.TestResult

fun main() {
    val suite = TestCaseTest.suite()
    val suite2 = TestCaseTest.suite()

    val result = TestResult()

    suite.add(suite2)

    suite.run(result)


    println(result.summary())
}
