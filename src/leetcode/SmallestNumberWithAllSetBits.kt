package leetcode

fun main() {
    val n1 = 5
    val n2 = 10
    val n3 = 3

    println(smallestNumber(n1))
    println(smallestNumber(n2))
    println(smallestNumber(n3))
}

private fun smallestNumber(n: Int): Int {
    var ans = 0
    var r = n

    while (r > 0) {
        r = r.shr(1)
        ans = ans.shl(1)
        ans++
    }

    return ans
}

// https://leetcode.com/problems/smallest-number-with-all-set-bits/description/