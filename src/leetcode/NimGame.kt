package leetcode

fun main() {
    val n1 = 4
    val n2 = 1
    val n3 = 2

    println(canWinNim(n1))
    println(canWinNim(n2))
    println(canWinNim(n3))
}

private fun canWinNim(n: Int) = n % 4 != 0

// https://leetcode.com/problems/nim-game/description/