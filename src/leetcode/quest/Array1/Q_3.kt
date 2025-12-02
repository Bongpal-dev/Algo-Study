package leetcode.quest.Array1

import kotlin.math.max

fun main() {
    val nums1 = intArrayOf(1, 1, 0, 1, 1, 1)
    val nums2 = intArrayOf(1, 0, 1, 1, 0, 1)

    println(findMaxConsecutiveOnes(nums1))
    println(findMaxConsecutiveOnes(nums2))
}

private fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var ans = 0
    var count = 0

    for (n in nums) {
        if (n == 0) {
            ans = maxOf(ans, count)
            count = 0
            continue
        }

        count++
    }

    return maxOf(ans, count)
}

// https://leetcode.com/problems/max-consecutive-ones/description/