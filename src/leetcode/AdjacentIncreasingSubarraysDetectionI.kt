package leetcode

fun main() {
    val (nums1, k1) = listOf(2, 5, 7, 8, 9, 2, 3, 4, 3, 1) to 3
    val (nums2, k2) = listOf(1, 2, 3, 4, 4, 4, 4, 5, 6, 7) to 5

    println(hasIncreasingSubarrays(nums1, k1))
    println(hasIncreasingSubarrays(nums2, k2))
}

private fun hasIncreasingSubarrays(nums: List<Int>, k: Int): Boolean {
    val arr = IntArray(nums.size) { 1 }

    for (i in 1..nums.lastIndex) {
        if (nums[i] > nums[i - 1]) {
            arr[i] = arr[i - 1] + 1
        }
    }

    for(j in 0 .. arr.lastIndex - k) {
        if(arr[j] >= k && arr[j+k] >= k) return true
    }

    return false
}

// https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/description/