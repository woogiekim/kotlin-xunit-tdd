package xunit.test

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.javaConstructor

class TestSuite : Test {

    private val tests: MutableList<Test> = mutableListOf()

    fun add(test: Test) {
        tests.add(test)
    }

    override fun run(result: TestResult) {
        this.tests.forEach { it.run(result) }
    }

    companion object {
        fun suite(testClass: KClass<out Test>): TestSuite {
            return TestSuite().apply {
                testClass.declaredFunctions
                    .filter { it.name.startsWith("test") }
                    .forEach { add(testClass.primaryConstructor!!.call(it.name)) }
            }
        }
    }
}
