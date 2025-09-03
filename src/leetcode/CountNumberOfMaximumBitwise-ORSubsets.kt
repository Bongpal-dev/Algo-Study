package leetcode

fun main() {
    val nums1 = intArrayOf(3, 1)
    val nums2 = intArrayOf(2, 2, 2)
    val nums3 = intArrayOf(3, 2, 1, 5)

    println(countMaxOrSubsets(nums1))
    println(countMaxOrSubsets(nums2))
    println(countMaxOrSubsets(nums3))
}

private fun countMaxOrSubsets(nums: IntArray): Int {
    var answer = 0
    val maxOr = nums.reduce { acc, n -> acc.or(n) }

    fun find(i: Int, o: Int) {
        if(i == nums.size) {
            if(o == maxOr) answer++

            return
        }

        find(i+1, o)
        find(i+1, o.or(nums[i]))
    }
    find(0, 0)

    return answer
}

// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/description/