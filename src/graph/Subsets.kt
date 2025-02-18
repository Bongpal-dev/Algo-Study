package graph

fun main() {
    println(subsets(intArrayOf(1, 2, 3)))
    println(subsets(intArrayOf(0)))
}

private fun subsets(nums: IntArray): List<List<Int>> {
    val answer = mutableListOf<List<Int>>()

    generate(0, mutableListOf(), nums, answer)

    return answer
}

private fun generate(i: Int, prev: MutableList<Int>, nums: IntArray, answer: MutableList<List<Int>>) {
    if (i > nums.size) return

    answer.add(prev.toList())

    for (j in i .. nums.lastIndex) {
        prev.add(nums[j])
        generate(j+1, prev, nums, answer)
        prev.removeLast()
    }
}

// https://leetcode.com/problems/subsets/description/