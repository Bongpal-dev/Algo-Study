package leetcode

fun main() {
    val accounts1 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(1, 2, 3),
    )
    val accounts2 = arrayOf(
        intArrayOf(1, 5),
        intArrayOf(7, 3),
        intArrayOf(3, 5),
    )
    val accounts3 = arrayOf(
        intArrayOf(2, 8, 7),
        intArrayOf(7, 1, 3),
        intArrayOf(1, 9, 5),
    )

    println(maximumWealth(accounts1))
    println(maximumWealth(accounts2))
    println(maximumWealth(accounts3))
}

private fun maximumWealth(accounts: Array<IntArray>) = accounts.maxOf { it.sum() }

// https://leetcode.com/problems/richest-customer-wealth/description/