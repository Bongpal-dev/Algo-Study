package leetcode

fun main() {
    val nums1 = intArrayOf(1, 3)
    val nums2 = intArrayOf(5, 1, 6)
    val nums3 = intArrayOf(3, 4, 5, 6, 7, 8)

    println(subsetXORSum(nums1))
    println(subsetXORSum(nums2))
    println(subsetXORSum(nums3))
}

private fun subsetXORSum(nums: IntArray): Int {
    val n = nums.size

    var ans = 0

    for (mask in 0 until (1 shl n)) {
        var s = 0

        for (i in 0 until n) {
            if ((mask shr i) and 1 == 1) {
                s = s.xor(nums[i])
            }
        }

        ans += s
    }
    return ans
}

// https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/