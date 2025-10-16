package leetcode

import kotlin.math.absoluteValue

fun main() {
    val (nums1, value1) = intArrayOf(1, -10, 7, 13, 6, 8) to 5
    val (nums2, value2) = intArrayOf(1, -10, 7, 13, 6, 8) to 7
    val (nums3, value3) = intArrayOf(3, 0, 3, 2, 4, 2, 1, 1, 0, 4) to 5
    val (nums4, value4) = intArrayOf(0, -3) to 4

    println(findSmallestInteger(nums1, value1))
    println(findSmallestInteger(nums2, value2))
    println(findSmallestInteger(nums3, value3))
    println(findSmallestInteger(nums4, value4))
}

private fun findSmallestInteger(nums: IntArray, value: Int): Int {
    val arr = IntArray(value)

    nums.forEach { num ->
        val idx = ((num % value) + value) % value

        arr[idx]++
    }

    var i = 0

    while (true) {
        val n = i % value

        if (arr[n] == 0) return i

        arr[n]--
        i++
    }
}

// https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations/description/