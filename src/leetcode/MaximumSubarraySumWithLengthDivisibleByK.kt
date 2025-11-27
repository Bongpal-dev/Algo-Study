package leetcode

fun main() {
    val (nums1, k1) = intArrayOf(1, 2) to 1
    val (nums2, k2) = intArrayOf(-1, -2, -3, -4, -5) to 4
    val (nums3, k3) = intArrayOf(-5, 1, 2, -3, 4) to 2

    println(maxSubarraySum(nums1, k1))
    println(maxSubarraySum(nums2, k2))
    println(maxSubarraySum(nums3, k3))
}

private fun maxSubarraySum(nums: IntArray, k: Int): Long {
    var ans = Long.MIN_VALUE
    val min = LongArray(k) { Long.MAX_VALUE }
    var sum = 0L

    min[0] = 0L

    for (i in nums.indices) {
        sum += nums[i]

        val g = (i + 1) % k

        if (min[g] != Long.MAX_VALUE) {
            ans = maxOf(ans, sum - min[g])
        }

        min[g] = minOf(min[g], sum)
    }

    return ans
}

// https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/description/