package leetcode

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 4, 5)
    val nums2 = intArrayOf(5)
    val nums3 = intArrayOf(
        0, 3, 3, 4, 1, 2, 6, 4, 9, 3,
        5, 1, 7, 7, 3, 0, 3, 2, 5, 1,
        9, 0, 2, 6, 3, 9, 2, 5, 9, 2,
        6, 4, 2, 9, 7, 2, 0, 3, 0, 1,
        1, 2, 7, 8, 6, 4, 4, 5
    )

//    println(triangularSum(nums1))
//    println(triangularSum(nums2))
    println(triangularSum(nums3))
}

private fun triangularSum(nums: IntArray): Int {
    val ans = nums.clone()

    for (s in ans.size - 1 downTo 1) {
        for (i in 0..s - 1) {
            ans[i] = (ans[i] + ans[i + 1]) % 10
        }
    }

    return ans[0]
}

// https://leetcode.com/problems/find-triangular-sum-of-an-array/description