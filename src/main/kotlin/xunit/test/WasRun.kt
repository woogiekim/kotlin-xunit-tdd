package xunit.test

class WasRun(name: String) : TestCase(name) {

    fun testMethod() {
        this.wasRun = true
        this.log += " testMethod"
    }
}
