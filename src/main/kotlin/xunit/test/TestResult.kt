package xunit.test

class TestResult {
    var runCount: Int = 0
        private set

    fun summary(): String {
        return "$runCount run, 0 failed"
    }

    fun testStarted() {
        this.runCount++
    }
}
