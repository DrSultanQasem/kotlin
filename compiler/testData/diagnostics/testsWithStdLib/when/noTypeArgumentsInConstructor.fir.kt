// !WITH_NEW_INFERENCE

import java.util.*

fun <T> nullable(x: T): T? = x

@Suppress("UNUSED_PARAMETER")
fun <T> select(x1: T, x2: T): T = x1

val test1 =
        listOf(1, 2, 3).mapNotNullTo(ArrayList()) {
            if (true) nullable(it) else null
        }

val test2: MutableList<Int?> =
        listOf(1, 2, 3).mapNotNullTo(ArrayList()) {
            if (true) nullable(it) else null
        }

val test3: MutableList<Int> =
        listOf(1, 2, 3).mapNotNullTo(ArrayList()) {
            if (true) nullable(it) else null
        }

val test4: Collection<Int> =
        listOf(1, 2, 3).<!AMBIGUITY!>flatMapTo<!>(LinkedHashSet()) {
            <!INAPPLICABLE_CANDIDATE!>listOf<!>(<!UNRESOLVED_REFERENCE!>it<!>)
        }

val test5: Collection<Int> =
        listOf(1, 2, 3).<!AMBIGUITY!>flatMapTo<!>(LinkedHashSet()) { // TODO
            if (true) <!INAPPLICABLE_CANDIDATE!>listOf<!>(<!UNRESOLVED_REFERENCE!>it<!>) else <!INAPPLICABLE_CANDIDATE!>listOf<!>(<!UNRESOLVED_REFERENCE!>it<!>)
        }

val test6: Collection<Int> =
        listOf(1, 2, 3).<!AMBIGUITY!>flatMapTo<!>(LinkedHashSet<Int>()) {
            if (true) <!INAPPLICABLE_CANDIDATE!>listOf<!>(<!UNRESOLVED_REFERENCE!>it<!>) else <!INAPPLICABLE_CANDIDATE!>listOf<!>(<!UNRESOLVED_REFERENCE!>it<!>)
        }

val test7: Collection<Int> =
        listOf(1, 2, 3).<!AMBIGUITY!>flatMapTo<!>(LinkedHashSet()) {
            <!INAPPLICABLE_CANDIDATE!>select<!>(<!INAPPLICABLE_CANDIDATE!>listOf<!>(<!UNRESOLVED_REFERENCE!>it<!>), <!INAPPLICABLE_CANDIDATE!>listOf<!>(<!UNRESOLVED_REFERENCE!>it<!>))
        }