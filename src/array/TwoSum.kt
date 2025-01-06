package array

fun main() {
    val (nums1, target1) = intArrayOf(2, 7, 11, 15) to 9
    val (nums2, target2) = intArrayOf(3, 2, 4) to 6
    val (nums3, target3) = intArrayOf(3, 3) to 6

    println(twoSum(nums1, target1).joinToString())
    println(twoSum(nums2, target2).joinToString())
    println(twoSum(nums3, target3).joinToString())
}

private fun twoSum(nums: IntArray, target: Int): IntArray {
    var answer = intArrayOf()

    for (n in nums.indices) {
        val t = target - nums[n]

        for (i in n + 1..<nums.size) {
            if (nums[i] == t) answer = intArrayOf(n, i)
        }
    }

    return answer
}

// https://leetcode.com/problems/two-sum/description/