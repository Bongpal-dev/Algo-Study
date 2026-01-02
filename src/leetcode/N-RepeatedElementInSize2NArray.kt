package leetcode

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 3)
    val nums2 = intArrayOf(2, 1, 2, 5, 3, 2)
    val nums3 = intArrayOf(5, 1, 5, 2, 5, 3, 5, 4)

    println(repeatedNTimes(nums1))
    println(repeatedNTimes(nums2))
    println(repeatedNTimes(nums3))
}

private fun repeatedNTimes(nums: IntArray): Int {
    val set = hashSetOf<Int>()

    for(n in nums) {
        if(n in set) return n else set.add(n)
    }

    return -1
}

// https://leetcode.com/problems/n-repeated-element-in-size-2n-array/description/