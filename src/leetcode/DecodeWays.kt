package leetcode

fun main() {
    val s1 = "12"
    val s2 = "226"
    val s3 = "06"
    val s4 = "27"
    val s5 = "100"

    println(numDecodings(s1))
    println(numDecodings(s2))
    println(numDecodings(s3))
    println(numDecodings(s4))
    println(numDecodings(s5))
}

private fun numDecodings(s: String): Int {
    if (s[0] == '0') return 0

    val dp = IntArray(s.length)

    dp[0] = 1

    for (i in 1..s.length - 1) {
        val current = s[i].digitToInt()
        val prev = s[i - 1].digitToInt()

        if (current != 0) {
            dp[i] += dp[i - 1]
        }

        if((prev*10) + current in 10 .. 26) {
            dp[i] += if(i > 1) dp[i-2] else 1
        }
    }

    return dp[s.length - 1]
}

// https://leetcode.com/problems/decode-ways/description/