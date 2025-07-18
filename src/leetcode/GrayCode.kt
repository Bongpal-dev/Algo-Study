package leetcode

fun main() {
    val n1 = 2
    val n2 = 1

    println(grayCode(n1))
    println(grayCode(n2))
}

private fun grayCode(n: Int): List<Int> {
    val answer = mutableListOf(0)

    for (i in 0 until n) {
        for (j in answer.lastIndex downTo 0) {
            val new = answer[j].or(1.shl(i))

            answer.add(new)
        }
    }
    return answer
}

// https://leetcode.com/problems/gray-code/description/