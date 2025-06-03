package leetcode

fun main() {
    val nums1 = intArrayOf(1, 2, 0)
    val nums2 = intArrayOf(3, 4, -1, 1)
    val nums3 = intArrayOf(7, 8, 9, 11, 12)

    println(firstMissingPositive(nums1))
    println(firstMissingPositive(nums2))
    println(firstMissingPositive(nums3))
}

private fun firstMissingPositive(nums: IntArray): Int {
    for (i in nums.indices) {
        while (
            nums[i] in 1..nums.size &&
            nums[nums[i] - 1] != nums[i]
        ) {
            nums[i] = nums[nums[i] - 1].also { nums[nums[i] - 1] = nums[i] }
        }
    }

    for (j in nums.indices) {
        if (nums[j] - 1 != j) return j + 1
    }

    return nums.size + 1
}

// https://leetcode.com/problems/first-missing-positive/description/