package leetcode

fun main() {
    val n1 = 3
    val n2 = 1

    println(generateMatrix(n1).joinToString("\n") { it.joinToString() })
    println(generateMatrix(n2).joinToString("\n") { it.joinToString() })
}

private fun generateMatrix(n: Int): Array<IntArray> {
    val answer = Array(n) { IntArray(n) }

    var t = 0
    var b = n - 1
    var l = 0
    var r = n - 1
    var num = 1

    while (t <= b && l <= r) {
        for (i in l..r) {
            answer[t][i] = num++
        }
        t++

        for (i in t..b) {
            answer[i][r] = num++
        }
        r--

        if (r >= l) {
            for (i in r downTo l) {
                answer[b][i] = num++
            }
            b--
        }

        if (b >= t) {
            for (i in b downTo t) {
                answer[i][l] = num++
            }
            l++
        }
    }

    return answer
}

// https://leetcode.com/problems/spiral-matrix-ii/description/