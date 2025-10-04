package leetcode

fun main() {
    val (nums1, n1) = intArrayOf(2, 5, 1, 3, 4, 7) to 3
    val (nums2, n2) = intArrayOf(1, 2, 3, 4, 4, 3, 2, 1) to 4
    val (nums3, n3) = intArrayOf(1, 1, 2, 2) to 2

    println(shuffle(nums1, n1).joinToString())
    println(shuffle(nums2, n2).joinToString())
    println(shuffle(nums3, n3).joinToString())
}

private fun shuffle(nums: IntArray, n: Int): IntArray {
    val ans = IntArray(nums.size)
    val mid = (nums.size - 1) / 2

    for (i in 0..mid) {
        val x = nums[i]
        val y = nums[i + n]

        ans[i * 2] = x
        ans[i * 2 + 1] = y
    }

    return ans
}

// https://leetcode.com/problems/shuffle-the-array/description/