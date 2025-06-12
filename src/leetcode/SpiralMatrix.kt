package leetcode

fun main() {
    val matrix1 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )
    val matrix2 = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12),
    )

    println(spiralOrder(matrix1))
    println(spiralOrder(matrix2))
}

private fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val answer = mutableListOf<Int>()

    var t = 0
    var b = matrix.size - 1
    var l = 0
    var r =  matrix[0].size - 1

    while (t <= b && l <= r) {
        for(x in l .. r) answer += matrix[t][x]

        t++

        for(y in t .. b) answer += matrix[y][r]

        r--

        if(t <= b) {
            for (x in r downTo l) answer += matrix[b][x]

            b--
        }

        if(l <= r) {
            for(y in b downTo t) answer += matrix[y][l]
            l++
        }
    }

    return answer
}

// https://leetcode.com/problems/spiral-matrix/description/