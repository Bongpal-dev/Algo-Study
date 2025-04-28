package baekjoon

import java.io.ByteArrayInputStream


fun main() {
    val inputs = listOf(
        "13\nbut\ni\nwont\nhesitate\nno\nmore\nno\nmore\nit\ncannot\nwait\nim\nyours"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val words = List(readLine().toInt()) { readLine() }

    words.toSortedSet(
        compareBy(
            {it.length},
            {it}
        )
    ).joinToString("\n").run(::println)
}

// https://www.acmicpc.net/problem/1181