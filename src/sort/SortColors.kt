package sort

import kotlin.math.min

fun main() {
    val nums1 = intArrayOf(2, 0, 2, 1, 1, 0)
    val nums2 = intArrayOf(2, 0, 1)

    sortColors(nums1)
    sortColors(nums2)
    println(nums1.joinToString())
    println(nums2.joinToString())
}

private fun sortColors(nums: IntArray): Unit {
    nums.quickSort(0, nums.lastIndex)
}

private fun IntArray.quickSort(s: Int, e: Int) {
    if (s >= e) return

    val pivot = this[s]
    var l = s + 1
    var h = e

    while (l <= h) {
        while (l <= e && this[l] <= pivot) l++
        while (h > s && this[h] >= pivot) h--
        if (l < h) this.swap(l, h)
    }
    this.swap(s, h)

    this.quickSort(s, h - 1)
    this.quickSort(h+1, e)
}

private fun IntArray.swap(a: Int, b: Int) {
    this[a] = this[b].also { this[b] = this[a] }
}

// https://leetcode.com/problems/sort-colors/description/