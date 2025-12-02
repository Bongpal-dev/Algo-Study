package leetcode.quest.Array1

fun main() {
    val (nums1, n1) = intArrayOf(2, 5, 1, 3, 4, 7) to 3
    val (nums2, n2) = intArrayOf(1, 2, 3, 4, 4, 3, 2, 1) to 4
    val (nums3, n3) = intArrayOf(1, 1, 2, 2) to 2

    println(shuffle(nums1, n1).joinToString())
    println(shuffle(nums2, n2).joinToString())
    println(shuffle(nums3, n3).joinToString())
}

private fun shuffle(nums: IntArray, n: Int) = IntArray(2 * n) { i -> if (i % 2 == 0) nums[i / 2] else nums[(i / 2) + n] }

// https://leetcode.com/problems/shuffle-the-array/description/