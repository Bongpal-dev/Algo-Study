package leetcode

fun main() {
    val (numBottles1, numExchange1) = 9 to 3
    val (numBottles2, numExchange2) = 15 to 4

    println(numWaterBottles(numBottles1, numExchange1))
    println(numWaterBottles(numBottles2, numExchange2))
}

private fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
    var ans = numBottles
    var r = numBottles

    while(r >= numExchange) {
        val ex = r / numExchange

        ans += ex
        r = (r % numExchange) + ex
    }

    return ans
}

// https://leetcode.com/problems/water-bottles/description