// BAD_FIR_RESOLUTION
// IGNORE_BACKEND_FIR: JVM_IR
enum class A {
    X {
        val x = "OK"

        inner class Inner {
            fun foo() = this@X.x
        }

        val z = Inner()

        override val test = z.foo()
    };

    abstract val test: String
}

fun box() = A.X.test
