package leetcode

fun main() {
    val s1 = "0110111"
    val s2 = "101"
    val s3 = "111111"

    println(numSub(s1))
    println(numSub(s2))
    println(numSub(s3))
}

private fun numSub(s: String): Int {
    var ans = 0L
    var one = 0

    for (c in s) {
        if (c == '1') {
            one++
        } else {
            ans += (one * (one + 1L) / 2) % 1000000007
            one = 0
        }
    }

    if (one > 0) ans += (one * (one + 1L) / 2) % 1000000007

    return ans.toInt()
}

// https://leetcode.com/problems/number-of-substrings-with-only-1s/description/