package leetcode

fun main() {
    val (nums1, target1) = intArrayOf(2, 5, 6, 0, 0, 1, 2) to 0
    val (nums2, target2) = intArrayOf(2, 5, 6, 0, 0, 1, 2) to 3

    println(search(nums1, target1))
    println(search(nums2, target2))
}

private fun search(nums: IntArray, target: Int): Boolean {
    var s = 0
    var e = nums.size - 1

    while (s <= e) {
        val mid = (s + e) / 2

        when {
            nums[mid] == target -> return true
            nums[s] == nums[mid] && nums[mid] == nums[e] -> {
                s++
                e--
            }

            nums[s] <= nums[mid] -> {
                if (target in nums[s]..<nums[mid]) e = mid - 1 else s = mid + 1
            }

            else -> {
                if (target in nums[mid]..nums[e]) s = mid + 1 else e = mid - 1
            }
        }
    }

    return false
}
// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/