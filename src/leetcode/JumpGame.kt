package leetcode

fun main() {
    val nums1 = intArrayOf(2, 3, 1, 1, 4)
    val nums2 = intArrayOf(3, 2, 1, 0, 4)
    val nums3 = intArrayOf(1, 2, 0, 1) // true
    val nums4 = intArrayOf(4, 2, 0, 0, 1, 1, 4, 4, 4, 0, 4, 0) // ture

    println(canJump(nums1))
    println(canJump(nums2))
    println(canJump(nums3))
    println(canJump(nums4))
}

private fun canJump(nums: IntArray): Boolean {
    var max = 0

    for (i in nums.indices) {
        if (i > max) {
            return false
        }
        max = maxOf(max, i + nums[i])
    }

    return true
}

// https://leetcode.com/problems/jump-game/description/