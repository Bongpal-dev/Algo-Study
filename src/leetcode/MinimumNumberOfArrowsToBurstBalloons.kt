package leetcode

fun main() {
    val points1 = arrayOf(intArrayOf(10, 16), intArrayOf(2, 8), intArrayOf(1, 6), intArrayOf(7, 12))
    val points2 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5, 6), intArrayOf(7, 8))
    val points3 = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(4, 5))

    println(findMinArrowShots(points1))
    println(findMinArrowShots(points2))
    println(findMinArrowShots(points3))
}

private fun findMinArrowShots(points: Array<IntArray>): Int {
    if (points.isEmpty()) return 0

    points.sortBy { it[0] }

    var answer = 1
    var l = points[0][0]
    var r = points[0][1]

    for (i in 1..points.size - 1) {
        val s = points[i][0]
        val e = points[i][1]

        if (s > r) {
            l = s
            r = e
            answer++
            continue
        } else {
            l = maxOf(s, l)
            r = minOf(e, r)
        }
    }

    return answer
}

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/