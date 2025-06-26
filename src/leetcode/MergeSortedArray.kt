package leetcode

fun main() {
    val (nums11, m1) = intArrayOf(1, 2, 3, 0, 0, 0) to 3
    val (nums21, n1) = intArrayOf(2, 5, 6) to 3
    val (nums12, m2) = intArrayOf(1) to 1
    val (nums22, n2) = intArrayOf() to 0
    val (nums13, m3) = intArrayOf(0) to 0
    val (nums23, n3) = intArrayOf(1) to 1
    val (nums14, m4) = intArrayOf(4, 5, 6, 0, 0, 0) to 3
    val (nums24, n4) = intArrayOf(1, 2, 3) to 3

    merge(nums11, m1, nums21, n1)
    merge(nums12, m2, nums22, n2)
    merge(nums13, m3, nums23, n3)
    merge(nums14, m4, nums24, n4)

    println(nums11.joinToString())
    println(nums12.joinToString())
    println(nums13.joinToString())
    println(nums14.joinToString())
}

private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    if (nums2.isEmpty()) return

    var c = m + n - 1
    var o = m - 1
    var t = n - 1

    while(t >= 0) {
        if(o >= 0 && nums1[o] > nums2[t]) {
            nums1[c] = nums1[o]
            o--
        } else {
            nums1[c] = nums2[t]
            t--
        }
        c--
    }
}

// https://leetcode.com/problems/merge-sorted-array/description/