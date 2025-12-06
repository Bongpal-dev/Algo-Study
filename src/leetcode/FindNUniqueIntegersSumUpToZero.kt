package leetcode

fun main() {
    val n1 = 5
    val n2 = 3
    val n3 = 1

    println(sumZero(n1).joinToString())
    println(sumZero(n2).joinToString())
    println(sumZero(n3).joinToString())
}

private fun sumZero(n: Int): IntArray {
    val ans = IntArray(n)
    var c = n / 2

    for (i in 0..c - 1) {
        val li = ans.lastIndex - i

        ans[i] = c * -1
        ans[li] = c
        c++
    }

    return ans
}

// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/