package shortestpath

import java.util.PriorityQueue

fun main() {
    val (n1, src1, dst1, k1) = listOf(4, 0, 3, 1)
    val flights1 = arrayOf(
        intArrayOf(0, 1, 100),
        intArrayOf(1, 2, 100),
        intArrayOf(2, 0, 100),
        intArrayOf(1, 3, 600),
        intArrayOf(2, 3, 200),
    )
    val (n2, src2, dst2, k2) = listOf(3, 0, 2, 1)
    val flights2 = arrayOf(
        intArrayOf(0, 1, 100),
        intArrayOf(1, 2, 100),
        intArrayOf(0, 2, 500),
    )
    val (n3, src3, dst3, k3) = listOf(3, 0, 2, 0)
    val flights3 = arrayOf(
        intArrayOf(0, 1, 100),
        intArrayOf(1, 2, 100),
        intArrayOf(0, 2, 500),
    )
    val (n4, src4, dst4, k4) = listOf(5, 2, 1, 1)
    val flights4 = arrayOf(
        intArrayOf(4, 1, 1),
        intArrayOf(1, 2, 3),
        intArrayOf(0, 3, 2),
        intArrayOf(0, 4, 10),
        intArrayOf(3, 1, 1),
        intArrayOf(1, 4, 3),
    )
    val (n5, src5, dst5, k5) = listOf(4, 0, 3, 1)
    val flights5 = arrayOf(
        intArrayOf(0, 1, 1),
        intArrayOf(0, 2, 5),
        intArrayOf(1, 2, 1),
        intArrayOf(2, 3, 1),
    )
    val (n6, src6, dst6, k6) = listOf(3, 0, 2, 1)
    val flights6 = arrayOf(
        intArrayOf(0, 1, 100),
        intArrayOf(1, 2, 100),
        intArrayOf(0, 2, 500),
    )
    val (n7, src7, dst7, k7) = listOf(5, 0, 2, 2)
    val flights7 = arrayOf(
        intArrayOf(0, 1, 5),
        intArrayOf(1, 2, 5),
        intArrayOf(0, 3, 2),
        intArrayOf(3, 1, 2),
        intArrayOf(1, 4, 1),
        intArrayOf(4, 2, 1),
    )

    println(findCheapestPrice(n1, flights1, src1, dst1, k1))
    println(findCheapestPrice(n2, flights2, src2, dst2, k2))
    println(findCheapestPrice(n3, flights3, src3, dst3, k3))
    println(findCheapestPrice(n4, flights4, src4, dst4, k4))
    println(findCheapestPrice(n5, flights5, src5, dst5, k5))
    println(findCheapestPrice(n6, flights6, src6, dst6, k6))
    println(findCheapestPrice(n7, flights7, src7, dst7, k7))
}

private fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
    val dp = Array(n) { IntArray(k + 2) { Int.MAX_VALUE } }
    val graph = hashMapOf<Int, MutableList<Ticket>>()
    val queue = PriorityQueue<Ticket>(compareBy { it.price })

    flights.forEach {
        graph.getOrPut(it[0]) { mutableListOf() }.add(Ticket(it[1], it[2], 0))
    }

    dp[src][0] = 0
    queue.add(Ticket(src, 0, 0))

    var answer = Int.MAX_VALUE

    while (queue.isNotEmpty()) {
        val current = queue.poll() ?: break

        if (current.destination == dst) answer = minOf(answer, current.price)

        if (current.stop == k + 1) continue

        for (d in graph[current.destination] ?: emptyList()) {
            val next = d.destination
            val stackPrice = current.price + d.price

            if (stackPrice < dp[next][current.stop + 1]) {
                dp[next][current.stop + 1] = stackPrice
                queue.add(Ticket(next, stackPrice, current.stop + 1))
            }
        }
    }

    return if (answer == Int.MAX_VALUE) -1 else answer
}

private data class Ticket(
    val destination: Int,
    val price: Int,
    val stop: Int
)

// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/