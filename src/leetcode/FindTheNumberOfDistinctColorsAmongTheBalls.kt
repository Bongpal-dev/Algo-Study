package leetcode

fun main() {
    val (limit1, queries1) = 4 to arrayOf(intArrayOf(1, 4), intArrayOf(2, 5), intArrayOf(1, 3), intArrayOf(3, 4))
    val (limit2, queries2) = 4 to arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(2, 2),
        intArrayOf(3, 4),
        intArrayOf(4, 5)
    )

    println(queryResults(limit1, queries1).joinToString())
    println(queryResults(limit2, queries2).joinToString())
}

private fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
    val answer = IntArray(queries.size)
    val balls = hashMapOf<Int, Int>()
    val count = hashMapOf<Int, Int>()

    for (i in queries.indices) {
        val (b, c) = queries[i]

        if (balls[b] != null) {
            if (count[balls[b]]!! - 1 == 0) {
                count.remove(balls[b])
            } else {
                count[balls[b]!!] = count[balls[b]]!! - 1
            }
        }

        balls[b] = c
        count[c] = count.getOrDefault(c, 0) + 1
        answer[i] = count.size
    }

    return answer
}

// https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/