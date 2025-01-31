package leetcode

fun main() {
    val (num11, num21) = intArrayOf(1, 3) to intArrayOf(2)
    val (num12, num22) = intArrayOf(1, 2) to intArrayOf(3, 4)

    println(findMedianSortedArrays(num11, num21))
    println(findMedianSortedArrays(num12, num22))
}

private fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val size = nums1.size + nums2.size
    val arr = IntArray(size) { -1 }
    var n1 = 0
    var n2 = 0

    for (i in 0..<size) {
        when {
            n1 > nums1.lastIndex -> arr[i] = nums2[n2++]
            n2 > nums2.lastIndex -> arr[i] = nums1[n1++]
            nums1[n1] < nums2[n2] -> arr[i] = nums1[n1++]
            nums1[n1] >= nums2[n2] -> arr[i] = nums2[n2++]
        }
    }

    return if (arr.size % 2 != 0) {
        arr[arr.size / 2].toDouble()
    } else {
        (arr[arr.size / 2] + arr[(arr.size / 2) - 1]).toDouble() / 2.0
    }
}

// https://leetcode.com/problems/median-of-two-sorted-arrays/description/