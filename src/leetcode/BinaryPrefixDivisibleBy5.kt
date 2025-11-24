package leetcode

fun main() {
    val nums1 = intArrayOf(0, 1, 1)
    val nums2 = intArrayOf(1, 1, 1)
    val nums3 = intArrayOf(0, 1, 1, 1, 1, 1)
    val nums4 = intArrayOf(1,0,1,1,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0,0,1,1,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,1,1,0,0,1,0)

    println(prefixesDivBy5(nums1))
    println(prefixesDivBy5(nums2))
    println(prefixesDivBy5(nums3))
    println(prefixesDivBy5(nums4))
}

private fun prefixesDivBy5(nums: IntArray): List<Boolean> {
    var n = 0

    return nums.map {
        n = n.shl(1)
        n += it
        n %= 5
        n % 5 == 0
    }
}

// https://leetcode.com/problems/binary-prefix-divisible-by-5/description/