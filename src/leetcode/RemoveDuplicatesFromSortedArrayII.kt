package leetcode

fun main() {
    val nums1 = intArrayOf(1, 1, 1, 2, 2, 3)
    val nums2 = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)

    println(removeDuplicates(nums1))
    println(removeDuplicates(nums2))
    println(nums1.joinToString())
    println(nums2.joinToString())
}

private fun removeDuplicates(nums: IntArray): Int {
    var i = 0
    var prev = -1
    var isTwice = false

    for (n in nums) {
        when {
            n == prev && isTwice -> {
                continue
            }
            n == prev && isTwice.not() -> {
                nums[i++] = n
                prev = n
                isTwice = true
            }
            else -> {
                isTwice = false
                nums[i++] = n
                prev = n
            }

        }
    }
    return i
}

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/