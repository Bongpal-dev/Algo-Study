package leetcode

fun main() {
    val nums1 = intArrayOf(2, 2, 3, 4)
    val nums2 = intArrayOf(4, 2, 3, 4)
    val nums3 = intArrayOf(0, 1, 1, 1)

    println(triangleNumber(nums1))
    println(triangleNumber(nums2))
    println(triangleNumber(nums3))
}

private fun triangleNumber(nums: IntArray): Int {
    if (nums.size < 3) return 0

    var ans = 0

    nums.sort()

    for (m in nums.size - 1 downTo 2) {
        var i = 0
        var j = m - 1

        while (i < j) {
            if (nums[i] + nums[j] > nums[m]) {
                ans += (j - i)
                j--
            } else {
                i++
            }
        }
    }

    return ans
}

// https://leetcode.com/problems/valid-triangle-number/description