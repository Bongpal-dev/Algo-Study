package bitcontroll

fun main() {
    val n1 = 11
    val n2 = 128
    val n3 = 2147483645

    println(hammingWeight(n1))
    println(hammingWeight(n2))
    println(hammingWeight(n3))
}

private fun hammingWeight(n: Int): Int {
    var answer = 0
    var remain = n

    while (remain > 0) {
        remain = remain.and(remain - 1) //  Brian Kernighan 알고리즘
        answer++
    }

    return answer
}

// https://leetcode.com/problems/number-of-1-bits/description/