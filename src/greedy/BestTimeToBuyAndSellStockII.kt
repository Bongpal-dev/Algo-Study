package greedy

fun main() {
    val prices1 = intArrayOf(7, 1, 5, 3, 6, 4)
    val prices2 = intArrayOf(1, 2, 3, 4, 5)
    val prices3 = intArrayOf(7, 6, 4, 3, 1)

    println(maxProfit(prices1))
    println(maxProfit(prices2))
    println(maxProfit(prices3))
}

private fun maxProfit(prices: IntArray): Int {
    var answer = 0
    var min = prices[0]
    var maxProfit = 0

    for (p in prices) {
        if (p < min) min = p

        val currentProfit = p - min

        maxProfit = maxOf(maxProfit, currentProfit)

        if (currentProfit < maxProfit) {
            answer += maxProfit
            maxProfit = 0
            min = p
        }
    }
    answer += maxProfit

    return answer
}

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/