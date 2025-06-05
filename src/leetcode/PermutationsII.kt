package leetcode

fun main() {
    val nums1 = intArrayOf(1, 1, 2)
    val nums2 = intArrayOf(1, 2, 3)

    println(permuteUnique(nums1))
    println(permuteUnique(nums2))
}

private fun permuteUnique(nums: IntArray): List<List<Int>> {
    val answer = mutableListOf<List<Int>>()
    val visited = BooleanArray(nums.size)

    nums.sort()
    find(nums, mutableListOf(), visited, answer)

    return answer
}

private fun find(nums: IntArray, n: MutableList<Int>, visited: BooleanArray, answer: MutableList<List<Int>>) {
    if (n.size == nums.size) {
        answer += n.toList()
        return
    }

    for (i in nums.indices) {
        if (visited[i]) continue

        if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue

        n += nums[i]
        visited[i] = true

        find(nums, n, visited, answer)

        visited[i] = false
        n.removeLast()
    }
}

// https://leetcode.com/problems/permutations-ii/description/