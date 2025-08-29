package leetcode

fun main() {
    val (n1, m1) = 3 to 2
    val (n2, m2) = 1 to 1

    println(flowerGame(n1, m1))
    println(flowerGame(n2, m2))
}

private fun flowerGame(n: Int, m: Int): Long {
    val ne = n / 2L
    val no = n - ne
    val me = m / 2L
    val mo = m - me

    return (no * me) + (mo * ne)
}

// https://leetcode.com/problems/alice-and-bob-playing-flower-game/description