package bitcontroll

fun main() {
    val nums1 = intArrayOf(2,2,1)
    val nums2 = intArrayOf(4,1,2,1,2)
    val nums3 = intArrayOf(1)

    println(singleNumber(nums1))
    println(singleNumber(nums2))
    println(singleNumber(nums3))
}

private fun singleNumber(nums: IntArray): Int {
    var answer = 0

    nums.forEach { answer = answer.xor(it) }

    return answer
}

// https://leetcode.com/problems/single-number/