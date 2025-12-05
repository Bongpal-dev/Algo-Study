package leetcode

import kotlin.math.absoluteValue

fun main() {
    val nums1 = intArrayOf(10, 10, 3, 7, 6)
    val nums2 = intArrayOf(1, 2, 2)
    val nums3 = intArrayOf(2, 4, 6, 8)

    println(countPartitions(nums1))
    println(countPartitions(nums2))
    println(countPartitions(nums3))
}

private fun countPartitions(nums: IntArray): Int {
    return if (nums.sum() % 2 == 0) nums.size - 1 else 0
}

// https://leetcode.com/problems/count-partitions-with-even-sum-difference/description/