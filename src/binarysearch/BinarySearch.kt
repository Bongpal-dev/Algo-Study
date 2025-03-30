package binarysearch

fun main() {
    val (nums1, target1) = intArrayOf(-1, 0, 3, 5, 9, 12) to 9
    val (nums2, target2) = intArrayOf(-1, 0, 3, 5, 9, 12) to 2
    val (nums3, target3) = intArrayOf(5) to 5

//    println(search(nums1, target1))
//    println(search(nums2, target2))
    println(search(nums3, target3))
}

private fun search(nums: IntArray, target: Int): Int {
    var answer = -1
    var mid = nums.lastIndex / 2
    var s = 0
    var e = nums.lastIndex

    while (mid >= s && e >= s) {
        if (nums[mid] == target) {
            answer = mid
            break
        }

        if (nums[mid] > target) {
            e = mid - 1
        } else {
            s = mid + 1
        }

        mid = (s + e) / 2
    }

    return answer
}

// https://leetcode.com/problems/binary-search/description/