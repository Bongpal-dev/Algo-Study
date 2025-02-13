package graph.basic

fun main() {
    val graph = hashMapOf<Int, List<Int>>()

    graph[1] = listOf(2, 3, 4)
    graph[2] = listOf(5)
    graph[3] = listOf(5)
    graph[4] = listOf()
    graph[5] = listOf(6, 7)
    graph[6] = listOf()
    graph[7] = listOf(3)

    println(iterativeBFS(1, graph))
}

private fun iterativeBFS(start: Int, graph: HashMap<Int, List<Int>>): List<Int> {
    val discover = mutableListOf<Int>()
    val queue = mutableListOf<Int>()

    discover.add(start)
    queue.add(start)

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()

        for (n in graph[current] ?: emptyList()) {
            if (discover.contains(n).not()) {
                discover.add(n)
                queue.add(n)
            }
        }
    }

    return discover
}