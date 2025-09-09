package leetcode

fun main() {
    val (n1, delay1, forget1) = listOf(6, 2, 4)
    val (n2, delay2, forget2) = listOf(4, 1, 3)

    println(peopleAwareOfSecret(n1, delay1, forget1))
    println(peopleAwareOfSecret(n2, delay2, forget2))
}

private fun peopleAwareOfSecret(n: Int, delay: Int, forget: Int): Int {
    val mod = 1000000007
    val dp = IntArray(n + 1)

    dp[1] = 1

    var current = 0L
    var total = 1L

    for (day in 2..n) {
        if (day - delay >= 1) {
            current = (current + dp[day - delay]) % mod
        }

        if (day - forget >= 1) {
            current = (current - dp[day - forget] + mod) % mod
            total = (total - dp[day - forget] + mod) % mod
        }

        dp[day] = current.toInt()
        total = (total + dp[day]) % mod
    }

    return total.toInt()
}

// https://leetcode.com/problems/number-of-people-aware-of-a-secret/description