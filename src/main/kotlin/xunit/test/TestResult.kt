package xunit.test

class TestResult {
    var runCount: Int = 0
        private set

    var errorCount: Int = 0
        private set

    fun summary(): String {
        return "$runCount run, $errorCount failed"
    }

    fun testStarted() {
        this.runCount++
    }

    fun testFailed() {
        this.errorCount++
    }
}
