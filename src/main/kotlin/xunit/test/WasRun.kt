package xunit.test

class WasRun(name: String) : TestCase(name) {

    var wasRun: Boolean = false
        private set

    fun testMethod() {
        this.wasRun = true
    }
}
