package baekjoon

import java.io.ByteArrayInputStream
import kotlin.math.roundToInt

fun main() {
    val inputs = listOf(
        "5\n1\n3\n8\n-2\n2",
        "1\n4000",
        "5\n-1\n-2\n-3\n-1\n-2",
        "3\n0\n0\n-1",
        "5\n1\n1\n2\n2\n3"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val answer = mutableListOf<Int>()
    val n = readLine().toInt()
    val nums = List(n) { readLine().toInt() }.sorted()
    val count = nums
        .groupingBy { it }
        .eachCount()
        .run { filter { it.value == values.max() } }
        .map { it.key }

    answer += (nums.sum().toDouble() / n).roundToInt()
    answer += nums[n / 2]
    answer += if (count.size > 1) count[1] else count[0]
    answer += nums.last() - nums.first()
    println(answer.joinToString("\n"))
}

// https://www.acmicpc.net/problem/2108