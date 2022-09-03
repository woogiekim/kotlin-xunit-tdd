package xunit.test

class TestSuite {
    private val tests: MutableList<TestCase> = mutableListOf()

    fun add(testCase: TestCase) {
        tests.add(testCase)
    }

    fun run(result: TestResult) {
        this.tests.forEach { it.run(result) }
    }
}
