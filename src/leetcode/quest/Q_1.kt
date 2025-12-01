package leetcode.quest

fun main() {
    val nums1 = intArrayOf(1, 2, 1)
    val nums2 = intArrayOf(1, 3, 2, 1)

    println(getConcatenation(nums1).joinToString())
    println(getConcatenation(nums2).joinToString())
}

private fun getConcatenation(nums: IntArray) =  IntArray(nums.size * 2) { nums[it % nums.size] }

// https://leetcode.com/problems/concatenation-of-array/description/