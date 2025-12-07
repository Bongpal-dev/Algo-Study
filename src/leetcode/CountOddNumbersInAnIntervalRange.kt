package leetcode

fun main() {
    val (low1, high1) = 3 to 7
    val (low2, high2) = 8 to 10

    println(countOdds(low1, high1))
    println(countOdds(low2, high2))
}

private fun countOdds(low: Int, high: Int) = (low..high).count { it % 2 != 0 }

// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/description/