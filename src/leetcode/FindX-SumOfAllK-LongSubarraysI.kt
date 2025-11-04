package leetcode

import java.util.*

fun main() {
    val nums1 = intArrayOf(1, 1, 2, 2, 3, 4, 2, 3)
    val (k1, x1) = 6 to 2
    val nums2 = intArrayOf(3, 8, 7, 8, 7, 5)
    val (k2, x2) = 2 to 2

    println(findXSum(nums1, k1, x1).joinToString())
    println(findXSum(nums2, k1, x1).joinToString())
}

private fun findXSum(nums: IntArray, k: Int, x: Int): IntArray {
    return IntArray(nums.size - k + 1) { i ->
        nums.slice(i until i + k)
            .groupingBy { it }
            .eachCount()
            .toList()
            .sortedWith(
                compareByDescending<Pair<Int, Int>> { it.second }
                    .thenByDescending { it.first }
            )
            .take(x)
            .sumOf { it.first * it.second }
    }
}

// http://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/description/