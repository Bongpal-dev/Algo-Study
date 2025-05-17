package leetcode

import kotlin.math.absoluteValue

fun main() {
    val (nums1, target1) = intArrayOf(-1, 2, 1, -4) to 1
    val (nums2, target2) = intArrayOf(0, 0, 0) to 1

    println(threeSumClosest(nums1, target1))
    println(threeSumClosest(nums2, target2))
}

private fun threeSumClosest(nums: IntArray, target: Int): Int {
    if (nums.size == 3) return nums.sum()

    nums.sort()

    var answer = nums[0] + nums[1] + nums[2]

    for (i in 0..nums.lastIndex - 2) {
        var l = i+1
        var r = nums.lastIndex

        while (l < r) {
            val sum = nums[i] + nums[l] + nums[r]

            if ((target - sum).absoluteValue < (target - answer).absoluteValue) {
                answer = sum
            }

            when {
                sum < target -> l++
                sum > target -> r--
                else -> return sum
            }
        }
    }

    return answer
}

// https://leetcode.com/problems/3sum-closest/description/