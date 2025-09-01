package leetcode

import kotlin.math.absoluteValue

fun main() {
    val boxes1 = "110"
    val boxes2 = "001011"

    println(minOperations(boxes1).joinToString())
    println(minOperations(boxes2).joinToString())
}

private fun minOperations(boxes: String): IntArray {
    val n = boxes.length
    val answer = IntArray(n)

    var l = 0
    var lm = 0

    for (i in 0..<n) {
        if (boxes[i] == '1') l++

        answer[i] += lm
        lm += l
    }

    var r = 0
    var rm = 0

    for (j in n - 1 downTo 0) {
        if (boxes[j] == '1') r++

        answer[j] += rm
        rm += r
    }

    return answer
}

// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/