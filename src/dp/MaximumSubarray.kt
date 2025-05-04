package dp

fun main() {
    val nums1 = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    val nums2 = intArrayOf(1)
    val nums3 = intArrayOf(5,4,-1,7,8)

    println(maxSubArray(nums1))
    println(maxSubArray(nums2))
    println(maxSubArray(nums3))
}

// Kadane 알고리즘
private fun maxSubArray(nums: IntArray): Int {
    var current = nums[0]
    var max = nums[0]

    for (i in 1 .. nums.lastIndex) {
        current = maxOf(nums[i], current + nums[i])
        max = maxOf(max, current)
    }

    return max
}

// https://leetcode.com/problems/maximum-subarray/