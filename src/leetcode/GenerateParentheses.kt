package leetcode

fun main() {
    val n1 = 3
    val n2 = 1

    println(generateParenthesis(n1))
    println(generateParenthesis(n2))
}

// DP풀이 (카탈란 수)
private fun generateParenthesis(n: Int): List<String> {
    val dp = Array(n + 1) { mutableListOf<String>() }

    dp[0] += ""

    for (i in 1..n) {
        for (j in 0 until i) {
            for (a in dp[j]) {
                for (b in dp[i - 1 - j]) {
                    dp[i] += "($a)$b"
                }
            }
        }
    }

    return dp[n]
}

/* 백트래킹 풀이
private fun generateParenthesis(n: Int): List<String> {
    val answer = mutableListOf<String>()

    find("", 0, 0, n, answer)

    return answer
}

private fun find(s: String, open: Int, close: Int, t: Int, answer: MutableList<String>) {
    if (s.length == t * 2) {
        answer += s
        return
    }

    if (open < t) find("$s(", open + 1, close, t, answer)

    if (close < open) find("$s)", open, close + 1, t, answer)
}
 */