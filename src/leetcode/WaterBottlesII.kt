package leetcode

fun main() {
    val (numBottles1, numExchange1) = 13 to 6
    val (numBottles2, numExchange2) = 10 to 3

    println(maxBottlesDrunk(numBottles1, numExchange1))
    println(maxBottlesDrunk(numBottles2, numExchange2))
}

private fun maxBottlesDrunk(numBottles: Int, numExchange: Int): Int {
    var ans = numBottles
    var cExNum = numExchange
    var empty = numBottles

    while (empty >= cExNum) {
        empty -= cExNum++
        ans++
        empty++
    }

    return ans
}

// https://leetcode.com/problems/water-bottles-ii/description