package divideandconquer

fun main() {
    val nums1 = intArrayOf(3, 2, 3)
    val nums2 = intArrayOf(2, 2, 1, 1, 1, 2, 2)

    println(majorityElement(nums1))
    println(majorityElement(nums2))
}

// 분할 정복
private fun majorityElement(nums: IntArray): Int {
    return nums.findMajor(0, nums.lastIndex)
}

private fun IntArray.findMajor(left: Int, right: Int): Int {
    if (left == right) return this[left]

    val mid = (left + right) / 2
    val leftMajor = this.findMajor(left, mid)
    val rightMajor = this.findMajor(mid + 1, right)

    if (leftMajor == rightMajor) return leftMajor

    val leftCount = this.countNum(left, mid, leftMajor)
    val rightCount = this.countNum(mid + 1, right, rightMajor)

    return if (leftCount > rightCount) leftMajor else rightMajor
}

private fun IntArray.countNum(start: Int, end: Int, num: Int): Int {
    var result = 0

    for (i in start..end) {
        if (this[i] == num) result++
    }

    return result
}


//// 보이어-무어 알고리즘
//private fun majorityElement(nums: IntArray): Int {
//    var candidate = -1
//    var count = 0
//
//    for (n in nums) {
//        if (count == 0) candidate = n
//
//        if (candidate == n) count++ else count--
//    }
//
//    return candidate
//}

// https://leetcode.com/problems/majority-element/description/