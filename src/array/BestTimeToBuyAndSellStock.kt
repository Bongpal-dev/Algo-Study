package array

fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    println(maxProfit(intArrayOf(2, 4, 1)))
}

private fun maxProfit(prices: IntArray): Int {
    var max = 0
    var min = Int.MAX_VALUE
    var profit = 0

    for (p in prices) {
        if (p < min) {
            min = p
            max = 0
        }
        max = maxOf(max, p)
        profit = maxOf(max - min, profit)
    }

    return profit
}

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/