// BAD_FIR_RESOLUTION
// IGNORE_BACKEND: JS_IR
// TODO: muted automatically, investigate should it be ran for JS or not
// DONT_RUN_GENERATED_CODE: JS
// IGNORE_BACKEND: JS

tailrec fun test(counter : Int) : Int {
    if (counter == 0) return 0

    try {
        // do nothing
    } finally {
        return test(counter - 1)
    }
}

fun box() : String = if (test(3) == 0) "OK" else "FAIL"
