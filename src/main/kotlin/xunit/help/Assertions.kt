package xunit.help

object Assertions {

    fun assertEquals(expected: Any, actual: Any) {
        if (expected != actual) {
            throw AssertionError("expected <$expected> but was <$actual>")
        }
    }
}