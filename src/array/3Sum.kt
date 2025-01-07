package array

fun main() {
    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
    println(threeSum(intArrayOf(0, 1, 1)))
    println(threeSum(intArrayOf(0, 0, 0)))
}

private fun threeSum(nums: IntArray): List<List<Int>> {
    val answer = mutableListOf<List<Int>>()

    nums.sort()

    for (i in nums.indices) {
        if (i > 0 && nums[i] == nums[i - 1]) continue

        var l = i + 1
        var r = nums.lastIndex

        while (l < r) {
            val sum = nums[i] + nums[l] + nums[r]

            if (sum == 0) {
                answer += listOf(nums[i], nums[l++], nums[r++])

                while (l in 1..<r && nums[l] == nums[l-1]) l++
                while (r in l ..< nums.lastIndex && nums[r] == nums[r+1]) r--
            }

            if (sum < 0) l++ else r--
        }
    }

    return answer
}

// https://leetcode.com/problems/3sum/