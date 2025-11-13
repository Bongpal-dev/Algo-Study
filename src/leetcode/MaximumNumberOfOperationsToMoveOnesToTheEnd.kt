package leetcode

fun main() {
    val s1 = "1001101"
    val s2 = "00111"
    val s3 = "110"

    println(maxOperations(s1))
    println(maxOperations(s2))
    println(maxOperations(s3))
}

private fun maxOperations(s: String): Int {
    var ans = 0
    var one = 0

    for (i in s.indices) {
        if (s[i] == '1') {
            one++
        } else {
            if (i == s.lastIndex || s[i + 1] == '1') {
                ans += one
            }
        }
    }

    return ans
}

// https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/description/