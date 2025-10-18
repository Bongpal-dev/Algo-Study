package leetcode

fun main() {
    val (nums1, k1) = intArrayOf(1, 2, 2, 3, 3, 4) to 2
    val (nums2, k2) = intArrayOf(4, 4, 4, 4) to 1
    val (nums3, k3) = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 5) to 3
    val (nums4, k4) = intArrayOf(10,10,10,5,10) to 1

    println(maxDistinctElements(nums1, k1))
    println(maxDistinctElements(nums2, k2))
    println(maxDistinctElements(nums3, k3))
    println(maxDistinctElements(nums4, k4))
}

private fun maxDistinctElements(nums: IntArray, k: Int): Int {
    nums.sort()

    var ans = 0
    var prev = Int.MIN_VALUE

    for(n in nums) {
        if(n + k < prev) continue

        prev = maxOf(n - k, prev) + 1
        ans ++
    }

    return ans
}

// https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations/description/