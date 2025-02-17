package graph

fun main() {
    val (candidates1, target1) = intArrayOf(2,3,6,7) to 7
    val (candidates2, target2) = intArrayOf(2,3,5) to 8
    val (candidates3, target3) = intArrayOf(2) to 1

    println(combinationSum(candidates1, target1))
    println(combinationSum(candidates2, target2))
    println(combinationSum(candidates3, target3))
}

private fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val answer = mutableListOf<List<Int>>()

    find(0, candidates, 0, mutableListOf(), target, answer)

    return answer
}

private fun find(s:Int, candidates: IntArray, sum: Int, prev: MutableList<Int>, target: Int, answer: MutableList<List<Int>>) {
    if (sum > target) return

    if (prev.isNotEmpty() && sum == target) {
        answer.add(prev.toList())
        return
    }

    for (i in s .. candidates.lastIndex) {
        prev.add(candidates[i])
        find(i, candidates, sum + candidates[i], prev, target, answer)
        prev.removeLast()
    }
}


// https://leetcode.com/problems/combination-sum/description/