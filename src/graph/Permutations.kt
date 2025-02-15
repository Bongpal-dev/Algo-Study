package graph

fun main() {
    println(permute(intArrayOf(1, 2, 3)))
    println(permute(intArrayOf(0, 1)))
    println(permute(intArrayOf(1)))
}

private fun permute(nums: IntArray): List<List<Int>> {
    val answer = mutableListOf<List<Int>>()

    for (n in nums) {
        find(nums, listOf(n), answer)
    }

    return answer
}

private fun find(nums: IntArray, prev: List<Int>, answer: MutableList<List<Int>>) {
    if (prev.size == nums.size) {
        answer.add(prev)
        return
    }

    for (m in nums) {
        if (prev.contains(m).not()) {
            find(nums, prev + m, answer)
        }
    }
}

// https://leetcode.com/problems/permutations/description/