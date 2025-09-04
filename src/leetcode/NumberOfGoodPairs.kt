package leetcode

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 1, 1, 3)
    val nums2 = intArrayOf(1, 1, 1, 1)
    val nums3 = intArrayOf(1, 2, 3)

    println(numIdenticalPairs(nums1))
    println(numIdenticalPairs(nums2))
    println(numIdenticalPairs(nums3))
}

private fun numIdenticalPairs(nums: IntArray): Int {
    var ans = 0

    for (i in nums.indices) {
        for (j in i + 1..nums.lastIndex) {
            if(nums[i] == nums[j]) ans++
        }
    }

    return ans
}

// https://leetcode.com/problems/number-of-good-pairs/description/