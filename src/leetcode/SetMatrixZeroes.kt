package leetcode

fun main() {
    val matrix1 = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 0, 1),
        intArrayOf(1, 1, 1),
    )
    val matrix2 = arrayOf(
        intArrayOf(0, 1, 2, 0),
        intArrayOf(3, 4, 5, 2),
        intArrayOf(1, 3, 1, 5),
    )

    setZeroes(matrix1)
    setZeroes(matrix2)

    println(matrix1.joinToString("\n") { it.joinToString() })
    println(matrix2.joinToString("\n") { it.joinToString() })
}

private fun setZeroes(matrix: Array<IntArray>): Unit {
    val visited = Array(matrix.size) { BooleanArray(matrix[0].size) }

    for (y in matrix.indices) {
        for (x in matrix[0].indices) {
            if(visited[y][x].not() && matrix[y][x] == 0) convert(x, y, matrix, visited)
        }
    }
}

private fun convert(x: Int, y: Int, matrix: Array<IntArray>, visited: Array<BooleanArray>) {
    for(ny in matrix.indices) {
        if(matrix[ny][x] != 0) visited[ny][x] = true
        matrix[ny][x] = 0
    }

    for(nx in matrix[0].indices) {
        if(matrix[y][nx] != 0) visited[y][nx] = true
        matrix[y][nx] = 0
    }
}

// https://leetcode.com/problems/set-matrix-zeroes/description/