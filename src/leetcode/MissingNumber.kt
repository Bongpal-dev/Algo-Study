package leetcode

fun main() {
    val nums1 = intArrayOf(3, 0, 1)
    val nums2 = intArrayOf(0, 1)
    val nums3 = intArrayOf(9,6,4,2,3,5,7,0,1)

    println(missingNumber(nums1))
    println(missingNumber(nums2))
    println(missingNumber(nums3))
}

private fun missingNumber(nums: IntArray): Int {
    val n = nums.size
    val t = n * (n + 1) / 2

    return t - nums.sum()
}

// https://leetcode.com/problems/missing-number/description/