package leetcode

fun main() {
    val nums1 = intArrayOf(1, 2, 2)
    val nums2 = intArrayOf(0)
    val nums3 = intArrayOf(1, 2, 3)

    println(subsetsWithDup(nums1))
    println(subsetsWithDup(nums2))
    println(subsetsWithDup(nums3))
}

private fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    val answer = mutableListOf<List<Int>>()
    val subSet = mutableListOf<Int>()

    nums.sort()

    fun generate(s: Int) {
        answer += subSet.toList()

        for(i in s .. nums.lastIndex) {
            if(i > s && nums[i] == nums[i-1]) continue

            subSet += nums[i]
            generate(i + 1)
            subSet.removeLast()
        }
    }

    generate(0)

    return answer
}

// https://leetcode.com/problems/subsets-ii/description/