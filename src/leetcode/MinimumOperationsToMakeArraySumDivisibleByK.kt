package leetcode

fun main() {
    val (nums1, k1) = intArrayOf(3, 9, 7) to 5
    val (nums2, k2) = intArrayOf(4, 1, 3) to 4
    val (nums3, k3) = intArrayOf(3, 2) to 6

    println(minOperations(nums1, k1))
    println(minOperations(nums2, k2))
    println(minOperations(nums3, k3))
}

fun minOperations(nums: IntArray, k: Int) = nums.sum() % k

// https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k/description/