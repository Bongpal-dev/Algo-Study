package leetcode

fun main() {
    val (nums1, k1) = intArrayOf(1,0,0,0,1,0,0,1) to 2
    val (nums2, k2) = intArrayOf(1,0,0,1,0,1) to 2

    println(kLengthApart(nums1, k1))
    println(kLengthApart(nums2, k2))
}

private fun kLengthApart(nums: IntArray, k: Int): Boolean {
    var start = false
    var c = 0

    for (n in nums) {
        if(n == 0) {
            c++
        } else {
            if (start.not()) {
                start = true
                c = 0
                continue
            }

            if(c < k) return false

            c = 0
        }
    }

    return true
}

// https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/description/