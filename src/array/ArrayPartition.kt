package array

fun main() {
    println(arrayPairSum(intArrayOf(1, 4, 3, 2)))
    println(arrayPairSum(intArrayOf(6, 2, 6, 5, 1, 2)))
}

private fun arrayPairSum(nums: IntArray) = nums
        .apply { sort() }
        .foldIndexed(0) { i, acc, n -> if (i % 2 == 0) acc + n else acc }

// https://leetcode.com/problems/array-partition/description/