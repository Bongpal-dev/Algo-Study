package leetcode

fun main() {
    val (nums1, `val1`) = intArrayOf(3, 2, 2, 3) to 3
    val (nums2, `val2`) = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2) to 2

    println(removeElement(nums1, `val1`))
    println(nums1.joinToString())
    println(removeElement(nums2, `val2`))
    println(nums2.joinToString())
}

private fun removeElement(nums: IntArray, `val`: Int): Int {
    var i = 0

    for(n in nums.indices) {
        if (nums[n] != `val`) nums[i++] = nums[n]
    }

    return i
}

// https://leetcode.com/problems/remove-element/description/