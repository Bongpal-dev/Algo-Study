package leetcode

fun main() {
    val rowIndex1 = 3
    val rowIndex2 = 0
    val rowIndex3 = 1

    println(getRow(rowIndex1))
    println(getRow(rowIndex2))
    println(getRow(rowIndex3))
}

private fun getRow(rowIndex: Int): List<Int> {
    val triangle = mutableListOf(listOf(1))

    repeat(rowIndex) { i ->
        val prevList = triangle[i]
        val currentList = mutableListOf(1)

        for (j in 0..prevList.size - 2) currentList += prevList[j] + prevList[j + 1]

        triangle += currentList + listOf(1)
    }

    return triangle[rowIndex]
}

// https://leetcode.com/problems/pascals-triangle-ii/description/