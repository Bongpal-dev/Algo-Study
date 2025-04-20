package greedy

fun main() {
    val (tasks1, n1) = charArrayOf('A', 'A', 'A', 'B', 'B', 'B') to 2
    val (tasks2, n2) = charArrayOf('A', 'C', 'A', 'B', 'D', 'B') to 1
    val (tasks3, n3) = charArrayOf('A', 'A', 'A', 'B', 'B', 'B') to 3

    println(leastInterval(tasks1, n1))
    println(leastInterval(tasks2, n2))
    println(leastInterval(tasks3, n3))
}

private fun leastInterval(tasks: CharArray, n: Int): Int {
    val counts = tasks.toList().groupingBy { it }.eachCount()
    val maxCount = counts.maxOf { it.value }
    val maxCountTaskCount = counts.count { it.value == maxCount }

    return maxOf(tasks.size, (maxCount - 1) * (n + 1) + maxCountTaskCount)
}

// https://leetcode.com/problems/task-scheduler/description/