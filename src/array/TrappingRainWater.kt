package array

import kotlin.math.max

fun main() {
    println(trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
    println(trap(intArrayOf(4, 2, 0, 3, 2, 5)))
    println(trap(intArrayOf(0, 0, 0)))
    println(trap(intArrayOf(2, 0, 2)))
}

private fun trap(height: IntArray): Int {
    if (height.size < 2) return 0

    var answer = 0
    var top = 0
    var topIndex = 0
    var trap = 0

    for (s in height.indices) {
        if (top <= height[s]) {
            answer += trap
            trap = 0
            top = height[s]
            topIndex = s
        } else {
            trap += top - height[s]
        }
    }

    top = 0
    trap = 0

    for (e in height.size - 1 downTo topIndex) {
        if (top <= height[e]) {
            answer += trap
            trap = 0
            top = height[e]
        } else {
            trap += top - height[e]
        }
    }

    return answer
}

// https://leetcode.com/problems/trapping-rain-water/description/