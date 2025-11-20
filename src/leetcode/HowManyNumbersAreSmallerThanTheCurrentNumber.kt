package leetcode

fun main() {
    val nums1 = intArrayOf(8, 1, 2, 2, 3)
    val nums2 = intArrayOf(6, 5, 4, 8)
    val nums3 = intArrayOf(7, 7, 7, 7)

    println(smallerNumbersThanCurrent(nums1).joinToString())
    println(smallerNumbersThanCurrent(nums2).joinToString())
    println(smallerNumbersThanCurrent(nums3).joinToString())
}

private fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    return IntArray(nums.size) { i -> nums.count { nums[i] > it } }
}

// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/