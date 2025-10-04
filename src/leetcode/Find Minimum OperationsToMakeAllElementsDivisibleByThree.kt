package leetcode

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 4)
    val nums2 = intArrayOf(3, 6, 9)

    println(minimumOperations(nums1))
    println(minimumOperations(nums2))
}

private fun minimumOperations(nums: IntArray): Int {
    return nums.count { it % 3 != 0 }
}

// https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/