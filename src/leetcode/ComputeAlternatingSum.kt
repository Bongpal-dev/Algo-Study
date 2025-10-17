package leetcode

fun main() {
    val nums1 = intArrayOf(1, 3, 5, 7)
    val nums2 = intArrayOf(100)

    println(alternatingSum(nums1))
    println(alternatingSum(nums2))
}

private fun alternatingSum(nums: IntArray) = nums.reduceIndexed { i, acc, n -> if (i % 2 != 0) acc - n else acc + n }

// https://leetcode.com/problems/compute-alternating-sum/description/