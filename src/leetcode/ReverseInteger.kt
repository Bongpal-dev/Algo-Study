package leetcode

fun main() {
    val x1 = 123
    val x2 = -123
    val x3 = 120
    val x4 = 1534236469

    println(reverse(x1))
    println(reverse(x2))
    println(reverse(x3))
    println(reverse(x4))
}

private fun reverse(x: Int): Int {
    var tx = x
    var answer = 0

    while (tx != 0) {
        answer *= 10
        answer += tx % 10
        tx /= 10
    }

    return answer
}

// https://leetcode.com/problems/reverse-integer/description/