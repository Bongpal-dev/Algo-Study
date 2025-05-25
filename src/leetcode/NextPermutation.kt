package leetcode

fun main() {
    val nums1 = intArrayOf(1, 2, 3)
    val nums2 = intArrayOf(3, 2, 1)
    val nums3 = intArrayOf(1, 1, 5)

    nextPermutation(nums1)
    nextPermutation(nums2)
    nextPermutation(nums3)
    println(nums1.joinToString())
    println(nums2.joinToString())
    println(nums3.joinToString())
}

private fun nextPermutation(nums: IntArray): Unit {
    var i = nums.size - 2

    while (i >= 0 && nums[i] >= nums[i + 1]) {
        i--
    }

    if(i >= 0) {
        var j = nums.size - 1

        while (nums[j] <= nums[i]) {
            j--
        }
        nums[i] = nums[j].also { nums[j] = nums[i] }
    }

    var l = i + 1
    var r = nums.size - 1

    while (l < r) {
        nums[l] = nums[r].also { nums[r] = nums[l] }
        l++
        r--
    }
}

// https://leetcode.com/problems/next-permutation/description/