package tree

fun main() {
    val (n1, edges1) = 4 to arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(1, 3))
    val (n2, edges2) = 6 to arrayOf(
        intArrayOf(3, 0),
        intArrayOf(3, 1),
        intArrayOf(3, 2),
        intArrayOf(3, 4),
        intArrayOf(5, 4)
    )

    println(findMinHeightTrees(n1, edges1))
    println(findMinHeightTrees(n2, edges2))
}

private fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    if (n == 1) return listOf(0)

    val graph = mutableMapOf<Int, MutableList<Int>>()
    val degrees = IntArray(n) { 0 }
    val queue = mutableListOf<Int>()
    var nodeCount = n

    edges.forEach {
        graph.getOrPut(it[0]) { mutableListOf() }.add(it[1])
        graph.getOrPut(it[1]) { mutableListOf() }.add(it[0])
        degrees[it[0]]++
        degrees[it[1]]++
    }

    degrees.forEachIndexed { i, v -> if (v == 1) queue.add(i) }

    while (nodeCount > 2) {
        nodeCount -= queue.size

        repeat(queue.size) {
            val l = queue.removeFirst()

            for (t in graph[l] ?: emptyList()) {
                degrees[t]--
                if (degrees[t] == 1) queue.add(t)
            }
        }
    }

    return queue
}

// https://leetcode.com/problems/minimum-height-trees/description/