package leetcode

fun main() {
    val (nums1, original1) = intArrayOf(5, 3, 6, 1, 12) to 3
    val (nums2, original2) = intArrayOf(2, 7, 9) to 4

    println(findFinalValue(nums1, original1))
    println(findFinalValue(nums2, original2))
}

private fun findFinalValue(nums: IntArray, original: Int): Int {
    nums.sort()

    var o = original

    for (n in nums) {
        when {
            n > o * 2 -> break
            n == o -> o *= 2
        }
    }

    return o
}

// https://leetcode.com/problems/keep-multiplying-found-values-by-two/description/