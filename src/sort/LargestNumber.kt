package sort

fun main() {
    val nums1 = intArrayOf(10, 2)
    val nums2 = intArrayOf(3, 30, 34, 5, 9)
    val nums3 = intArrayOf(432, 43243)
    val nums4 = intArrayOf(111311, 1113)

    println(largestNumber(nums1))
    println(largestNumber(nums2))
    println(largestNumber(nums3))
    println(largestNumber(nums4))
}

private fun largestNumber(nums: IntArray): String {
    val result = nums.map { it.toString() }
        .sortedWith { o1, o2 ->
            (o2 + o1).compareTo(o1 + o2)
        }.joinToString("")

    return if (result.first() == '0') "0" else result
}

// https://leetcode.com/problems/largest-number/description/