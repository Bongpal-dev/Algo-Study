package leetcode

fun main() {
    val (intervals1, newInterval1) = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(6, 9),
    ) to intArrayOf(2, 5)
    val (intervals2, newInterval2) = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 5),
        intArrayOf(6, 7),
        intArrayOf(8, 10),
        intArrayOf(12, 16),
    ) to intArrayOf(4, 8)

    println(insert(intervals1, newInterval1).joinToString() { it.joinToString() })
    println(insert(intervals2, newInterval2).joinToString() { it.joinToString() })
}

private fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val answer = mutableListOf<IntArray>()
    var nMin = newInterval[0]
    var nMax = newInterval[1]
    var inserted = false

    for (i in intervals) {
        if (i[1] < newInterval[0]) {
            answer += i
            continue
        }

        if (i[0] > newInterval[1]) {
            if (inserted.not()) {
                answer += intArrayOf(nMin, nMax)
                inserted = true
            }
            answer += i
            continue
        }

        nMin = minOf(nMin, i[0])
        nMax = maxOf(nMax, i[1])
    }

    if (!inserted) {
        answer += intArrayOf(nMin, nMax)
    }

    return answer.toTypedArray()
}

// https://leetcode.com/problems/insert-interval/description/