package leetcode

fun main() {
    val nums1 = intArrayOf(1, 1, 0, 1)
    val nums2 = intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)
    val nums3 = intArrayOf(1, 1, 1)

    println(longestSubarray(nums1))
    println(longestSubarray(nums2))
    println(longestSubarray(nums3))
}

private fun longestSubarray(nums: IntArray): Int {
    if (nums.all { it == 1 }) return nums.size - 1

    var max = 0
    var prev = 0
    var current = 0

    for (n in nums) {
        if (n == 1) {
            current++
        } else {
            prev = current
            current = 0
        }

        max = maxOf(max, prev + current)
    }

    return max
}

// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description