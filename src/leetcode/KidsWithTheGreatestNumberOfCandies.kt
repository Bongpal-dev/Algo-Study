package leetcode

fun main() {
    val (candies1, extraCandies1) = intArrayOf(2, 3, 5, 1, 3) to 3
    val (candies2, extraCandies2) = intArrayOf(4, 2, 1, 1, 2) to 1
    val (candies3, extraCandies3) = intArrayOf(12, 1, 12) to 10

    println(kidsWithCandies(candies1, extraCandies1))
    println(kidsWithCandies(candies2, extraCandies2))
    println(kidsWithCandies(candies3, extraCandies3))
}

private fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
    val max = candies.max()

    return candies.map { it + extraCandies >= max }
}

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/