package leetcode

fun main() {
    val nums1 = intArrayOf(3, 6, 5, 1, 8)
    val nums2 = intArrayOf(4)
    val nums3 = intArrayOf(1, 2, 3, 4, 4)

    println(maxSumDivThree(nums1))
    println(maxSumDivThree(nums2))
    println(maxSumDivThree(nums3))
}

private fun maxSumDivThree(nums: IntArray): Int {
    val dp = IntArray(3) { Int.MIN_VALUE }

    dp[0] = 0

    for (n in nums) {
        val prev = dp.copyOf()

        for (i in 0..2) {
            if(prev[i] < 0) continue

            val sum = prev[i] + n
            val new = sum % 3

            dp[new] = maxOf(dp[new], sum)
        }
    }

    return dp[0]
}

// https://leetcode.com/problems/greatest-sum-divisible-by-three/description/