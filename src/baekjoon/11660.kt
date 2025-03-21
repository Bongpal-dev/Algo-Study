package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "4 3\n1 2 3 4\n2 3 4 5\n3 4 5 6\n4 5 6 7\n2 2 3 4\n3 4 3 4\n1 1 4 4",
        "2 4\n1 2\n3 4\n1 1 1 1\n1 2 1 2\n2 1 2 1\n2 2 2 2"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val arr = List(n) { readLine().split(" ").map { it.toInt() }.toMutableList() }

    for (i in 0..n - 1) {
        var sum = 0

        for (j in 0..n - 1) {
            sum += arr[i][j]

            if (i > 0) {
                sum += arr[i - 1][j]

                if (j > 0) sum -= arr[i - 1][j - 1]
            }

            arr[i][j] = sum
        }
    }

    readLines().map { q ->
        val (x1, y1, x2, y2) = q.split(" ").map { it.toInt() - 1 }
        val sum = arr[x2][y2]
        val xSub = if (x1 > 0) arr[x1 - 1][y2] else 0
        val ySub = if (y1 > 0) arr[x2][y1 - 1] else 0
        val add = if (x1 > 0 && y1 > 0) arr[x1 - 1][y1 - 1] else 0

        sum - xSub - ySub + add
    }.let {
        println(it.joinToString("\n"))
    }
}

// https://www.acmicpc.net/problem/11660