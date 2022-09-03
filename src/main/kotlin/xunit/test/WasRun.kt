package xunit.test

class WasRun(name: String) : TestCase(name) {

    fun testMethod() {
        this.log += " testMethod"
    }

    fun testBrokenMethod() {
        throw AssertionError()
    }
}
