package leetcode

fun main() {
    val (candidates1, target1) = intArrayOf(10, 1, 2, 7, 6, 1, 5) to 8
    val (candidates2, target2) = intArrayOf(2, 5, 2, 1, 2) to 5
    val (candidates3, target3) = intArrayOf(1, 1) to 2

    println(combinationSum2(candidates1, target1))
    println(combinationSum2(candidates2, target2))
    println(combinationSum2(candidates3, target3))
}

private fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val answer = mutableListOf<List<Int>>()

    candidates.sort()
    candidates.find(0, target, mutableListOf(), answer)

    return answer
}

private fun IntArray.find(s: Int, t: Int, prev: MutableList<Int>, answer: MutableList<List<Int>>) {
    if (t == 0) {
        answer += prev.toList()
        return
    }

    for (i in s..this.lastIndex) {
        if (i > s && this[i] == this[i - 1]) continue

        val num = this[i]

        if (num > t) break

        prev += num
        this.find(i + 1, t - num, prev, answer)
        prev.removeLast()
    }
}

// https://leetcode.com/problems/combination-sum-ii/description/