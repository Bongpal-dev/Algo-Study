package leetcode.quest.Array2

fun main() {
    val nums1 = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
    val nums2 = intArrayOf(1, 1)

    println(findDisappearedNumbers(nums1))
    println(findDisappearedNumbers(nums2))
}

private fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val ans = mutableListOf<Int>()
    val v = IntArray(nums.size + 1)

    nums.forEach { v[it]++ }

    for (i in 1..v.lastIndex) {
        if (v[i] == 0) ans += i
    }

    return ans
}

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/