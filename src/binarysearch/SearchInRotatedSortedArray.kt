package binarysearch

fun main() {
    val (nums1, target1) = intArrayOf(4, 5, 6, 7, 0, 1, 2) to 0
    val (nums2, target2) = intArrayOf(4, 5, 6, 7, 0, 1, 2) to 3
    val (nums3, target3) = intArrayOf(1) to 0

    println(search(nums1, target1))
    println(search(nums2, target2))
    println(search(nums3, target3))
}

private fun search(nums: IntArray, target: Int): Int {
    var l = 0
    var r = nums.lastIndex

    while (l <= r) {
        val mid = (l + r) / 2

        if (nums[mid] == target) return mid

        if (nums[l] <= nums[mid]) {
            if (target in nums[l]..nums[mid]) r = mid - 1 else l = mid + 1
        } else {
            if (target in nums[mid]..nums[r]) l = mid + 1 else r = mid - 1
        }
    }

    return -1
}

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/