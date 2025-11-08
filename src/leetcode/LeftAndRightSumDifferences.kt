package leetcode

import kotlin.math.absoluteValue

fun main() {
    val nums1 = intArrayOf(10, 4, 8, 3)
    val nums2 = intArrayOf(1)

    println(leftRightDifference(nums1).joinToString())
    println(leftRightDifference(nums2).joinToString())
}

private fun leftRightDifference(nums: IntArray): IntArray {
    val l = IntArray(nums.size)
    val r = IntArray(nums.size)

    for (i in 1..nums.lastIndex) {
        l[i] += l[i - 1] + nums[i - 1]
        r[nums.lastIndex - i] = r[nums.lastIndex - i + 1] + nums[nums.lastIndex - i + 1]
    }

    return IntArray(nums.size) { (l[it] - r[it]).absoluteValue}
}

// https://leetcode.com/problems/left-and-right-sum-differences/description/