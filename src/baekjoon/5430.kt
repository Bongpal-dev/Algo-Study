package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "5\nRDD\n4\n[1,2,3,4]\nDD\n1\n[42]\nRRD\n6\n[1,1,2,3,5,8]\nD\n0\n[]\nRDD\n4\n[1, 2, 3, 4]"
    )
    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val t = readLine().toInt()
    val cases = List(t) {
        TestCase(
            input = readLine(),
            size = readLine().toInt(),
            elements = readLine().let { case ->
                case.substring(1,case.lastIndex)
                    .split(",")
                    .mapNotNull { it.toIntOrNull() }
                    .toMutableList()
            }
        )
    }

    cases.forEach { execute(it.elements, it.input) }
}

private fun execute(e: MutableList<Int>, input: String) {
    var isReverse = false

    input.forEach { w ->
        when (w) {
            'R' -> isReverse = isReverse.not()
            'D' -> {
                val drop = if (isReverse) e.removeLastOrNull() else e.removeFirstOrNull()

                if (drop == null) {
                    println("error")
                    return
                }
            }
        }
    }

    if (isReverse) e.reverse()

    println(e.joinToString(",", "[", "]"))
}

private data class TestCase(
    val input: String,
    val size: Int,
    val elements: MutableList<Int>
)

// https://www.acmicpc.net/problem/5430