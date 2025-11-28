package leetcode

fun main() {
    val (nums1, k1) = intArrayOf(1, 2, 3, 4, 5, 6, 7) to 3
    val (nums2, k2) = intArrayOf(-1, -100, 3, 99) to 2

    rotate(nums1, k1)
    rotate(nums2, k2)
    println(nums1.joinToString())
    println(nums2.joinToString())
}

private fun rotate(nums: IntArray, k: Int): Unit {
    if (nums.isEmpty()) return

    val n = nums.size
    val r = k % n

    if (r == 0) return

    val m = IntArray(n - r) { nums[it] }

    for (i in 0..<r) {
        nums[i] = nums[i + (n - r)]
    }

    for (j in m.indices) {
        nums[r + j] = m[j]
    }
}

// https://leetcode.com/problems/rotate-array/description/