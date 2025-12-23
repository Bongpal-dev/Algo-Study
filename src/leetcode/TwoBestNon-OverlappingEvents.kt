package leetcode

fun main() {
    val events1 = arrayOf(
        intArrayOf(1, 3, 2),
        intArrayOf(4, 5, 2),
        intArrayOf(2, 4, 3),
    )
    val events2 = arrayOf(
        intArrayOf(1, 3, 2),
        intArrayOf(4, 5, 2),
        intArrayOf(1, 5, 5),
    )
    val events3 = arrayOf(
        intArrayOf(1, 3, 5),
        intArrayOf(1, 5, 1),
        intArrayOf(6, 6, 5),
    )

    println(maxTwoEvents(events1))
    println(maxTwoEvents(events2))
    println(maxTwoEvents(events3))
}

private fun maxTwoEvents(events: Array<IntArray>): Int {
    events.sortBy { it[1] }

    val dp = events.getDp()
    var ans = 0

    for (i in events.indices) {
        val s = events[i][0]
        val t = events[i][2]
        val prev = events.findPrev(i, s)

        ans = if (prev == -1) maxOf(ans, t) else maxOf(ans, dp[prev] + t)
    }

    return ans
}

private fun Array<IntArray>.getDp(): IntArray {
    return IntArray(this.size).also { dp ->
        dp[0] = this[0][2]

        for (i in 1..this.lastIndex) {
            dp[i] = maxOf(dp[i - 1], this[i][2])
        }
    }
}

private fun Array<IntArray>.findPrev(i: Int, s: Int): Int {
    var l = 0
    var r = i - 1

    while (l <= r) {
        val mid = (l + r) / 2

        if(this[mid][1] < s) {
            l = mid + 1
        } else {
            r = mid - 1
        }
    }

    return r
}

// https://leetcode.com/problems/two-best-non-overlapping-events/description/