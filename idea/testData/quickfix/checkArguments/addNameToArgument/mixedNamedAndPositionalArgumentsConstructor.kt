// "Add name to argument: 'b = "FOO"'" "true"
// LANGUAGE_VERSION: 1.3

class A(a: Int, b: String) {}

fun f() {
     A(a = 1, <caret>"FOO")
}