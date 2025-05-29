package leetcode

fun main() {
    val (nums1, target1) = intArrayOf(1, 3, 5, 6) to 5
    val (nums2, target2) = intArrayOf(1, 3, 5, 6) to 2
    val (nums3, target3) = intArrayOf(1, 3, 5, 6) to 7

    println(searchInsert(nums1, target1))
    println(searchInsert(nums2, target2))
    println(searchInsert(nums3, target3))
}

private fun searchInsert(nums: IntArray, target: Int): Int {
    var s = 0
    var e = nums.size - 1

    while(s <= e) {
        val mid = (s + e).ushr(1)

        when {
            nums[mid] == target -> return mid
            nums[mid] > target -> e = mid - 1
            nums[mid] < target -> s = mid + 1
        }
    }

    return s
}

// https://leetcode.com/problems/search-insert-position/description/