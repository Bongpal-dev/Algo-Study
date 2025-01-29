package deque

fun main() {
    val (points1, k1) = arrayOf(intArrayOf(1, 3), intArrayOf(-2, 2)) to 1
    val (points2, k2) = arrayOf(intArrayOf(3, 3), intArrayOf(-5, 1), intArrayOf(-2, 4)) to 2

    println(
        kClosest(points1, k1).joinToString(prefix = "[", postfix = "]") {
            it.joinToString(prefix = "[", postfix = "]")
        }
    )
    println(
        kClosest(points2, k2).joinToString(prefix = "[", postfix = "]") {
            it.joinToString(prefix = "[", postfix = "]")
        }
    )
}

private fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    val answer = Array(k) { intArrayOf() }
    val distance = points.mapIndexed { i, n -> i to (0 - n[0]).pow + (0 - n[1]).pow }.sortedBy { it.second }

    for (i in 1..k) {
        val idx = distance[i-1].first
        answer[i-1] = points[idx]
    }

    return answer
}

private val Int.pow get() = run { this * this }

// https://leetcode.com/problems/k-closest-points-to-origin/description/