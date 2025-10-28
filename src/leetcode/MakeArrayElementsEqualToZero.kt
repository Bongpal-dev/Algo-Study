package leetcode

import kotlin.math.absoluteValue

fun main() {
    val nums1 = intArrayOf(1, 0, 2, 0, 3)
    val nums2 = intArrayOf(2, 3, 4, 0, 4, 1, 0)

    println(countValidSelections(nums1))
    println(countValidSelections(nums2))
}

private fun countValidSelections(nums: IntArray): Int {
    var ans = 0

    val ltr = IntArray(nums.size)
    val rtl = IntArray(nums.size)

    var ls = 0
    var rs = 0

    for(i in nums.indices) {
        ls += nums[i]
        ltr[i] = ls
        rs += nums[nums.size-i-1]
        rtl[nums.size-i-1] = rs
    }

    for(j in nums.indices) {
        if(nums[j] != 0) continue

        when {
            ltr[j] == rtl[j] -> ans += 2
            (ltr[j] - rtl[j]).absoluteValue == 1 -> ans++
        }
    }

    return ans
}

// https://leetcode.com/problems/make-array-elements-equal-to-zero/description/