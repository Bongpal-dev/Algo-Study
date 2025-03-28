package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "11\n1 4\n3 5\n0 6\n5 7\n3 8\n5 9\n6 10\n8 11\n8 12\n2 13\n12 14", // 4
        "3\n1 1\n1 2\n1 1", // 3
        "4\n1 1\n1 4\n2 3\n4 4", // 3
        "4\n1 3\n2 2\n2 4\n3 3", // 2
        "4\n1 1\n2 2\n2 2\n3 3", // 4
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val reserve = List(readLine().toInt()) { readLine().split(" ").map { it.toInt() } }.sortedWith(compareBy({it.first()},{it.last()}))
    var count = 1
    var s = reserve[0][0]
    var e = reserve[0][1]

    for (i in 1..reserve.lastIndex) {
        if (reserve[i][0] in 0..s && reserve[i][1] in e..reserve.lastIndex && reserve[i][0] == reserve[i][1]) {
            count++
            continue
        }

        if (reserve[i][0] in s..e && reserve[i][1] < e) {
            s = reserve[i][0]
            e = reserve[i][1]
            continue
        }

        if (reserve[i][0] >= e) {
            s = reserve[i][0]
            e = reserve[i][1]
            count++
        }
    }
    println(count)
}

// https://www.acmicpc.net/problem/1931