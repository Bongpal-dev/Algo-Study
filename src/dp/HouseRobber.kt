package dp

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 1)
    val nums2 = intArrayOf(2, 7, 9, 3, 1)
    val nums3 = intArrayOf(2, 1, 1, 2)

    println(rob(nums1))
    println(rob(nums2))
    println(rob(nums3))
}

private fun rob(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]

    val dp = IntArray(nums.size + 1)

    dp[1] = nums[0]

    for (i in 1..nums.lastIndex) {
        dp[i + 1] = maxOf(nums[i] + dp[i - 1], dp[i])
    }

    return dp[dp.lastIndex]
}

// https://leetcode.com/problems/house-robber/submissions/1626634334/