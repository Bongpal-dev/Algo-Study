package graph

fun main() {
    println(combine(4, 2))
    println(combine(1, 1))
}

private fun combine(n: Int, k: Int): List<List<Int>> {
    val answer = mutableListOf<List<Int>>()

    generate(1, n, k, mutableListOf(), answer)

    return answer
}

private fun generate(start: Int, n: Int, k: Int, current: MutableList<Int>, answer: MutableList<List<Int>>) {
    if (current.size == k) {
        answer.add(current.toList())
        return
    }

    for (i in start..n) {
        current.add(i)
        generate(i + 1, n, k, current, answer)
        current.removeAt(current.size - 1)
    }
}

// https://leetcode.com/problems/combinations/description/