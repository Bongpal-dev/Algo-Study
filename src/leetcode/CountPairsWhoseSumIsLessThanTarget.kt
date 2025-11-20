package leetcode

fun main() {
    val (nums1, target1) = listOf(-1, 1, 2, 3, 1) to 2
    val (nums2, target2) = listOf(-6, 2, 5, -2, -7, -1, 3) to -2

    println(countPairs(nums1, target1))
    println(countPairs(nums2, target2))
}

private fun countPairs(nums: List<Int>, target: Int): Int {
    var ans = 0

    for (i in nums.indices) {
        for (j in i + 1..nums.lastIndex) {
            if (nums[i] + nums[j] < target) ans++
        }
    }

    return ans
}

// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/