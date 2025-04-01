package binarysearch

fun main() {
    val (nums11, nums21) = intArrayOf(1, 2, 2, 1) to intArrayOf(2, 2)
    val (nums12, nums22) = intArrayOf(4, 9, 5) to intArrayOf(9, 4, 9, 8, 4)
    val (nums13, nums23) = intArrayOf(1) to intArrayOf(1)

    println(intersection(nums11, nums21).joinToString())
    println(intersection(nums12, nums22).joinToString())
    println(intersection(nums13, nums23).joinToString())
}

private fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val answer = mutableSetOf<Int>()
    val (s, c) = if (nums1.lastIndex > nums2.lastIndex) nums1.apply { sort() } to nums2 else nums2.apply { sort() } to nums1

    c.forEach {
        if (s.isContains(it)) answer += it
    }

    return answer.toIntArray()
}

private fun IntArray.isContains(n: Int): Boolean {
    var mid: Int
    var l = 0
    var h = this.size - 1

    while (l <= h) {
        mid = (l + h) / 2

        if (this[mid] < n) {
            l = mid + 1
        } else {
            h = mid - 1
        }

        if (this[mid] == n) return true
    }

    return false
}

// https://leetcode.com/problems/intersection-of-two-arrays/description/