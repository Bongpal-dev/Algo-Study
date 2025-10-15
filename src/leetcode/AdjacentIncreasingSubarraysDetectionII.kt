package leetcode

fun main() {
    val nums1 = listOf(2, 5, 7, 8, 9, 2, 3, 4, 3, 1)
    val nums2 = listOf(1, 2, 3, 4, 4, 4, 4, 5, 6, 7)

    println(maxIncreasingSubarrays(nums1))
    println(maxIncreasingSubarrays(nums2))
}

private fun maxIncreasingSubarrays(nums: List<Int>): Int {
    var ans = 0
    val l = IntArray(nums.size) { 1 }
    val r = IntArray(nums.size) { 1 }

    for (i in 1..nums.lastIndex) {
        if (nums[i] > nums[i - 1]) l[i] = l[i - 1] + 1
    }

    for (j in r.lastIndex - 1 downTo 0) {
        if (nums[j + 1] > nums[j]) r[j] = r[j + 1] + 1
    }

    for (i in 0 until nums.lastIndex) {
        ans = maxOf(ans, minOf(l[i], r[i + 1]))
    }

    return ans
}

// https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii/description/