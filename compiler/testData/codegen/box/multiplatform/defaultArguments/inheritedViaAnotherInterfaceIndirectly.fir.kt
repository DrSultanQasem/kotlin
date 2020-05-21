// BAD_FIR_RESOLUTION
// !LANGUAGE: +MultiPlatformProjects
// IGNORE_BACKEND_FIR: JVM_IR

// FILE: lib.kt

package foo

expect interface H {
    fun foo(x: String = "default"): String
}

// FILE: main.kt
package foo

actual interface H {
    actual fun foo(x: String): String
}

interface I: H {
    override fun foo(x: String): String = "I.foo($x)"
}

interface J : I {
    override fun foo(x: String): String
}

interface K : J {
    override fun foo(x: String): String = "K.foo($x)"
}

class A : I

class B : K

fun box(): String {
    val a = A()
    var r = a.foo()
    if (r != "I.foo(default)") return "fail: A.foo()"
    r = a.foo("Q")
    if (r != "I.foo(Q)") return "fail A.foo(Q): $r"

    val b = B()
    r = b.foo()
    if (r != "K.foo(default)") return "fail B.foo(): $r"
    r = b.foo("W")
    if (r != "K.foo(W)") return "fail B.foo(W): $r"

    return "OK"
}
