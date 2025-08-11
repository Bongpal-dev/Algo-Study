package leetcode

fun main() {
    val nums1 = intArrayOf(2, 2, 3, 2)
    val nums2 = intArrayOf(0, 1, 0, 1, 0, 1, 99)

    println(singleNumber(nums1))
    println(singleNumber(nums2))
}

private fun singleNumber(nums: IntArray): Int {
    var one = 0
    var two = 0

    for (n in nums) {
        val nOne = (one.xor(n)).and(two.inv())
        val nTwo = (two.xor(n)).and(nOne.inv())

        one = nOne
        two = nTwo
    }

    return one
}

// https://leetcode.com/problems/single-number-ii/description/