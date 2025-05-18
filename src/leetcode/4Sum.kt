package leetcode

fun main() {
    val (nums1, target1) = intArrayOf(1, 0, -1, 0, -2, 2) to 0
    val (nums2, target2) = intArrayOf(2, 2, 2, 2, 2) to 8
    val (nums3, target3) = intArrayOf(1000000000, 1000000000, 1000000000, 1000000000) to -294967296

    println(fourSum(nums1, target1))
    println(fourSum(nums2, target2))
    println(fourSum(nums3, target3))
}

private fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    if (nums.size < 4) return emptyList()
    if (nums.size == 4 && nums.sum() != target) return emptyList()

    val answer = mutableListOf<List<Int>>()

    nums.sort()

    for (i in 0..nums.size - 3) {
        if (i > 0 && nums[i] == nums[i - 1]) continue

        for (j in i + 1..nums.size - 2) {
            if (j > i + 1 && nums[j] == nums[j - 1]) continue

            var l = j + 1
            var r = nums.lastIndex

            while (l < r) {
                val sum = nums[i].toLong() + nums[j] + nums[l] + nums[r]

                when {
                    sum == target.toLong() -> {
                        answer += listOf(nums[i], nums[j], nums[l], nums[r])
                        l++
                        r--

                        while (l < r && nums[l] == nums[l - 1]) l++
                        while (l < r && nums[r] == nums[r + 1]) r--
                    }

                    sum < target -> l++

                    else -> r--
                }
            }
        }
    }

    return answer
}

// https://leetcode.com/problems/4sum/description/