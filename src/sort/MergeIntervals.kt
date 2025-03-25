package sort

fun main() {
    val intervals1 = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
    val intervals2 = arrayOf(intArrayOf(1, 4), intArrayOf(4, 5))

    println(merge(intervals1).joinToString(prefix = "[", postfix = "]") {
        it.joinToString(
            prefix = "[",
            postfix = "]"
        )
    })
    println(merge(intervals2).joinToString(prefix = "[", postfix = "]") {
        it.joinToString(
            prefix = "[",
            postfix = "]"
        )
    })
}

private fun merge(intervals: Array<IntArray>): Array<IntArray> {
    var answer = mutableListOf<IntArray>()

    intervals.sortWith(compareBy({ it.first() }, { it.last() }))

    var s = intervals[0][0]
    var e = intervals[0][1]

    for (i in 1..intervals.lastIndex) {
        if (e >= intervals[i][0]) {
            e = maxOf(intervals[i][1], e)
        } else {
            answer += intArrayOf(s, e)
            s = intervals[i][0]
            e = intervals[i][1]
        }
    }

    answer += intArrayOf(s, e)

    return answer.toTypedArray()
}

// https://leetcode.com/problems/merge-intervals/description/