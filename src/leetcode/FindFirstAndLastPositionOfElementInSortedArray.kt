package leetcode

fun main() {
    val (nums1, target1) = intArrayOf(5, 7, 7, 8, 8, 10) to 8
    val (nums2, target2) = intArrayOf(5, 7, 7, 8, 8, 10) to 6
    val (nums3, target3) = intArrayOf() to 0

    println(searchRange(nums1, target1).joinToString())
    println(searchRange(nums2, target2).joinToString())
    println(searchRange(nums3, target3).joinToString())
}

private fun searchRange(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty()) return intArrayOf(-1, -1)

    val s = nums.findBoundary(target, true)
    val e = nums.findBoundary(target, false)

    return intArrayOf(s, e)
}

private fun IntArray.findBoundary(t: Int, isStart: Boolean): Int {
    var s = 0
    var e = this.size - 1
    var result = -1

    while (s <= e) {
        val mid = (s + e).ushr(1)

        when {
            this[mid] < t -> s = mid + 1
            this[mid] > t -> e = mid - 1
            else -> {
                result = mid

                if(isStart) e = mid - 1 else s = mid + 1
            }
        }
    }

    return result
}

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/