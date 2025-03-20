package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "10\n1 2 3 4 5 6 7 8 9 10",
        "4\n500000000 -500000000 500000000 1000000000"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val nums = readLines()[1].split(" ").map { it.toInt() }.sorted()
    var answer = 0

    for (i in 0..nums.lastIndex) {
        var s = 0
        var e = nums.lastIndex

        while (s < e) {
            if (s == i) {
                s++
                continue
            }

            if (e == i) {
                e--
                continue
            }

            val t = nums[i]
            val sum = nums[s] + nums[e]

            if (t == sum) {
                answer++
                break
            }

            if (t < sum) e-- else s++
        }
    }
    println(answer)
}

// https://www.acmicpc.net/problem/1253