package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "55-50+40",
        "10+20+30+40",
        "00009-00009",
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    var answer = 0
    val buffer = StringBuilder()
    var isAdd = true

    readLine().forEach { c ->
        if (c.isDigit()) {
            buffer.append(c)
            return@forEach
        }

        if (isAdd) {
            answer += buffer.toString().toInt()
        } else {
            answer -= buffer.toString().toInt()
        }

        if (c == '-') isAdd = false
        buffer.clear()
    }

    if (isAdd) {
        answer += buffer.toString().toInt()
    } else {
        answer -= buffer.toString().toInt()
    }

    println(answer)
}

// https://www.acmicpc.net/problem/1541