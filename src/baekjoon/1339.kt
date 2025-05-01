package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "2\nAAA\nAAA",
        "2\nGCF\nACDEB",
        "10\nA\nB\nC\nD\nE\nF\nG\nH\nI\nJ",
        "2\nAB\nBA",
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val s = List(n) { readLine() }
    val chars = MutableList(26) { 0 }
    val nums = MutableList(10) { 9 - it }
    var sum = 0


    s.forEach {
        var t = 1

        for (i in it.length - 1 downTo 0) {
            val current = it[i].code - 65

            chars[current] += t
            t *= 10
        }
    }

    chars.sortByDescending { it }
    for (n in chars) {
        if (n > 0) {
            val v = nums.removeFirst()

            sum += n * v
        } else {
            break
        }
    }
    println(sum)
}

// https://www.acmicpc.net/problem/1339