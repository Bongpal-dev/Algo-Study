package leetcode

fun main() {
    val (order1, friends1) = intArrayOf(3, 1, 2, 5, 4) to intArrayOf(1, 3, 4)
    val (order2, friends2) = intArrayOf(1, 4, 5, 3, 2) to intArrayOf(2, 5)

    println(recoverOrder(order1, friends1).joinToString())
    println(recoverOrder(order2, friends2).joinToString())
}

private fun recoverOrder(order: IntArray, friends: IntArray): IntArray {
    val f = friends.toHashSet()

    return order.filter { it in f }.toIntArray()
}

// https://leetcode.com/problems/restore-finishing-order/description/