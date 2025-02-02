package leetcode

fun main() {
    println(check(intArrayOf(3, 4, 5, 1, 2)))
    println(check(intArrayOf(2, 1, 3, 4)))
    println(check(intArrayOf(1, 2, 3)))
}

private fun check(nums: IntArray): Boolean {
    if (nums.size == 1) return true

    var isSorted = false

    for (i in nums.indices) {
        var prev = -1

        for (j in nums.indices) {
            val n = nums[(j + i)%nums.size]

            isSorted = true

            if (n < prev) {
                isSorted = false
                break
            }
            prev = n
        }

        if (isSorted) break
    }

    return isSorted
}


// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description