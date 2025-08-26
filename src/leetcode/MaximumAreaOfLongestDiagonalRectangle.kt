package leetcode

fun main() {
    val dimensions1 = arrayOf(intArrayOf(9, 3), intArrayOf(8, 6))
    val dimensions2 = arrayOf(intArrayOf(3, 4), intArrayOf(4, 3))

    println(areaOfMaxDiagonal(dimensions1))
    println(areaOfMaxDiagonal(dimensions2))
}

private fun areaOfMaxDiagonal(dimensions: Array<IntArray>): Int {
    var answer = 0
    var m = 0

    for (d in dimensions) {
        val cd = (d[0] * d[0]) + (d[1] * d[1])

        answer = when {
            cd == m -> maxOf(answer, d[0] * d[1])
            cd > m -> d[0] * d[1]
            else -> answer
        }

        m = maxOf(cd, m)
    }

    return answer
}

// https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle/description