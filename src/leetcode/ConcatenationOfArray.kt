package leetcode

fun main() {
    val nums1 = intArrayOf(1, 2, 1)
    val nums2 = intArrayOf(1, 3, 2, 1)

    println(getConcatenation(nums1).joinToString())
    println(getConcatenation(nums2).joinToString())
}

private fun getConcatenation(nums: IntArray): IntArray {
    val ans = IntArray(nums.size * 2)

    for(i in nums.indices) {
        ans[i] = nums[i]
        ans[i + nums.size] = nums[i]
    }

    return ans
}

// https://leetcode.com/problems/concatenation-of-array/description/