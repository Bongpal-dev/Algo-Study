package divideandconquer

fun main() {
    val nums1 = intArrayOf(3, 2, 3)
    val nums2 = intArrayOf(2, 2, 1, 1, 1, 2, 2)

    println(majorityElement(nums1))
    println(majorityElement(nums2))
}

// 보이어-무어 알고리즘
private fun majorityElement(nums: IntArray): Int {
    var candidate = -1
    var count = 0

    for (n in nums) {
        if (count == 0) candidate = n

        if (candidate == n) count++ else count--
    }

    return candidate
}

// https://leetcode.com/problems/majority-element/description/