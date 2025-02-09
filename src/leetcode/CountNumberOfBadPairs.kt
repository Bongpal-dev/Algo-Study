package leetcode

fun main() {
    println(countBadPairs(intArrayOf(4, 1, 3, 3)))
    println(countBadPairs(intArrayOf(1, 2, 3, 4, 5)))
}

private fun countBadPairs(nums: IntArray): Long {
    if (nums.size == 1) return 0L

    val m = hashMapOf<Int, Int>()
    val total = (nums.size.toLong() * (nums.size - 1)) / 2
    var good = 0L

    for (i in nums.indices) {
        val k = nums[i] - i

        good += m.getOrDefault(k, 0)
        m[k] = m.getOrDefault(k, 0) + 1
    }

    return total - good
}

// https://leetcode.com/problems/count-number-of-bad-pairs/description/