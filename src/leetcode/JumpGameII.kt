package leetcode

fun main() {
    val nums1 = intArrayOf(2, 3, 1, 1, 4)
    val nums2 = intArrayOf(2, 3, 0, 1, 4)
    val nums3 = intArrayOf(2, 1)

    println(jump(nums1))
    println(jump(nums2))
    println(jump(nums3))
}

private fun jump(nums: IntArray): Int {
    var max = 0
    var end = 0
    var count = 0

    for(i in 0 until nums.lastIndex) {
        max = maxOf(max, i + nums[i])

        if(i == end) {
            count++
            end = max
        }
    }

    return count
}

// https://leetcode.com/problems/jump-game-ii/description/