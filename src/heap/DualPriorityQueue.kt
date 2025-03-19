package heap

import java.util.*

fun main() {
    val operations1 = arrayOf("I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1")
    val operations2 = arrayOf("I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333")
    val operations3 = arrayOf("I 10", "I 20", "D 1", "I 30", "I 40", "D -1", "D -1")

    println(solution(operations1).joinToString())
    println(solution(operations2).joinToString())
    println(solution(operations3).joinToString())
}

private fun solution(operations: Array<String>): IntArray {
    val max = PriorityQueue<Int>(Collections.reverseOrder())
    val min = PriorityQueue<Int>()

    operations.forEach {
        val (o, v) = it.split(" ")
        val vi = v.toInt()

        if (o == "I") {
            max.add(vi)
            min.add(vi)
        }

        if (o == "D" && vi == 1) {
            min.remove(max.poll())
        }

        if (o == "D" && vi == -1) {
            max.remove(min.poll())
        }
    }

    return intArrayOf(max.poll() ?: 0, min.poll() ?: 0)
}

// https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=kotlin