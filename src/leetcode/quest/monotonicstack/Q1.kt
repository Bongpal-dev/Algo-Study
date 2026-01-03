package leetcode.quest.monotonicstack

fun main() {
    val prices1 = intArrayOf(8, 4, 6, 2, 3)
    val prices2 = intArrayOf(1, 2, 3, 4, 5)
    val prices3 = intArrayOf(10, 1, 1, 6)

    println(finalPrices(prices1).joinToString())
    println(finalPrices(prices2).joinToString())
    println(finalPrices(prices3).joinToString())
}

private fun finalPrices(prices: IntArray): IntArray {
    val stack = mutableListOf<Int>()

    for (i in prices.indices) {
        while (stack.isNotEmpty() && prices[stack.last()] >= prices[i]) {
            val j = stack.removeLast()

            prices[j] = prices[j] - prices[i]
        }

        stack += i
    }

    return prices
}

// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/description/