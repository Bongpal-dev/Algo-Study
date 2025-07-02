package leetcode

fun main() {
    val numRows1 = 5
    val numRows2 = 1

    println(generate(numRows1))
    println(generate(numRows2))
}

private fun generate(numRows: Int): List<List<Int>> {
    val answer = mutableListOf(listOf(1))

    repeat(numRows - 1) { i ->
        val prevList = answer[i]
        val currentList = mutableListOf(1)

        for (j in 0..prevList.size - 2) currentList += prevList[j] + prevList[j + 1]

        answer += currentList + listOf(1)
    }

    return answer
}

// https://leetcode.com/problems/pascals-triangle/description/