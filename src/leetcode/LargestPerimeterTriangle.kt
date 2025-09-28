package leetcode

fun main() {
    val nums1 = intArrayOf(2, 1, 2)
    val nums2 = intArrayOf(1, 2, 1, 10)
    val nums3 = intArrayOf(3, 6, 2, 3)

    println(largestPerimeter(nums1))
    println(largestPerimeter(nums2))
    println(largestPerimeter(nums3))
}

private fun largestPerimeter(nums: IntArray): Int {
    nums.sort()

    for (i in nums.lastIndex downTo 2) {
        val a = nums[i - 2]
        val b = nums[i - 1]
        val c = nums[i]

        if (a + b > c) return a + b + c
    }

    return 0
}

// https://leetcode.com/problems/largest-perimeter-triangle/description