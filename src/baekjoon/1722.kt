package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "4\n1 3",
        "4\n2 1 3 2 4",
        "4\n2 3 4 1 2",
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
    val p = readLine().split(" ").map { it.toLong() }

    val f = (1..n).runningFold(1L) { acc, i -> acc * i }.toLongArray()
    val nums = MutableList(n) { it + 1L }

    val answer = mutableListOf<Long>()

    if (p[0] == 1L) {
        var k = p[p.lastIndex] - 1L

        for (i in n downTo 1) {
            answer += nums.removeAt((k / f[i - 1]).toInt())
            k %= f[i - 1]
        }
    } else {
        var sum = 1L
        val list = p.subList(1, n + 1)

        list.forEach { n ->
            val count = nums.indexOf(n)

            sum += count * f[nums.lastIndex]
            nums.remove(n)
        }
        answer += sum
    }

    println(answer.joinToString(" "))
}

// https://www.acmicpc.net/problem/1722