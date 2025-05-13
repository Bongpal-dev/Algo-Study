package leetcode

fun main() {
    val height1 = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    val height2 = intArrayOf(1, 1)
    val height3 = intArrayOf(1, 2, 1)
    val height4 = intArrayOf(1, 3, 2, 5, 25, 24, 5)

    println(maxArea(height1))
    println(maxArea(height2))
    println(maxArea(height3))
    println(maxArea(height4))
}

private fun maxArea(height: IntArray): Int {
    var l = 0
    var r = height.lastIndex
    var max = calculateArea(height, l, r)

    while (l < r) {
        if (height[r] > height[l]) l++ else r--

        max = maxOf(calculateArea(height, l, r),max)
    }

    return max
}

private fun calculateArea(height: IntArray, l: Int, r: Int): Int {
    val h = minOf(height[l], height[r])
    val s = r - l

    return h * s
}

// https://leetcode.com/problems/container-with-most-water/description/