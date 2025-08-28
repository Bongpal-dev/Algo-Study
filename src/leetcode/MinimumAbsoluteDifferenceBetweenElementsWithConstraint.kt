package leetcode

import java.util.*
import kotlin.math.absoluteValue

fun main() {
    val (nums1, x1) = listOf(4, 3, 2, 4) to 2
    val (nums2, x2) = listOf(5, 3, 2, 10, 15) to 1
    val (nums3, x3) = listOf(1, 2, 3, 4) to 3

    println(minAbsoluteDifference(nums1, x1))
    println(minAbsoluteDifference(nums2, x2))
    println(minAbsoluteDifference(nums3, x3))
}

private fun minAbsoluteDifference(nums: List<Int>, x: Int): Int {
    var answer = Int.MAX_VALUE
    val set = TreeSet<Int>()

    for (i in x..nums.lastIndex) {
        set.add(nums[i - x])

        val c = nums[i]

        set.floor(c)?.let { answer = minOf(answer, (c - it).absoluteValue) }
        set.ceiling(c)?.let { answer = minOf(answer, (c - it).absoluteValue) }
    }

    return answer
}

// https://leetcode.com/problems/minimum-absolute-difference-between-elements-with-constraint/description/