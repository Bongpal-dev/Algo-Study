package leetcode

fun main() {
    val n1 = 4
    val n2 = 10
    val n3 = 20
    val n4 = 26

    println(totalMoney(n1))
    println(totalMoney(n2))
    println(totalMoney(n3))
    println(totalMoney(n4))
}

private fun totalMoney(n: Int): Int {
    val sums = IntArray(8) { it }.runningReduce { acc, i -> acc + i }
    val today = n % 7
    val week = n / 7

    var ans = sums[today] + (today * week)

    for ((add, i) in (1 .. week).withIndex()) {
        ans += sums[7] + (add * 7)
    }

    return ans
}

// https://leetcode.com/problems/calculate-money-in-leetcode-bank/description/