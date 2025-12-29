package leetcode

fun main() {
    val (n1, start1) = 5 to 0
    val (n2, start2) = 4 to 3

    println(xorOperation(n1, start1))
    println(xorOperation(n2, start2))
}

private fun xorOperation(n: Int, start: Int) = (0..n).reduce { acc, i -> acc.xor(start + 2 * (i - 1)) }

// https://leetcode.com/problems/xor-operation-in-an-array/description/