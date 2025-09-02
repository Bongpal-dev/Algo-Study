package leetcode

fun main() {
    val (nums1, pivot1) = intArrayOf(9, 12, 5, 10, 14, 3, 10) to 10
    val (nums2, pivot2) = intArrayOf(-3, 4, 3, 2) to 2

    println(pivotArray(nums1, pivot1).joinToString())
    println(pivotArray(nums2, pivot2).joinToString())
}

private fun pivotArray(nums: IntArray, pivot: Int): IntArray {
    val answer = mutableListOf<Int>()

    for(n in nums) if(n < pivot) answer += n
    for(n in nums) if(n == pivot) answer += n
    for(n in nums) if(n > pivot) answer += n

    return answer.toIntArray()
}

// https://leetcode.com/problems/partition-array-according-to-given-pivot/description/