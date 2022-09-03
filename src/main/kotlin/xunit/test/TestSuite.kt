package xunit.test

class TestSuite : Test {
    private val tests: MutableList<Test> = mutableListOf()

    fun add(test: Test) {
        tests.add(test)
    }

    override fun run(result: TestResult) {
        this.tests.forEach { it.run(result) }
    }
}
