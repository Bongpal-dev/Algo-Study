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

    println(recursiveDFS(1, mutableListOf(), graph))
    println(iterativeDFS(1, graph))

}

private fun recursiveDFS(v: Int, discover: MutableList<Int>, graph: HashMap<Int, List<Int>>): List<Int> {
    discover.add(v)

    for (n in graph[v] ?: emptyList()) {
        if (discover.contains(n).not()) {
            recursiveDFS(n, discover, graph)
        }
    }

    return discover
}

private fun iterativeDFS(v: Int, graph: HashMap<Int, List<Int>>): List<Int> {
    val discover = mutableListOf<Int>()
    val stack = mutableListOf<Int>()

    stack.add(v)

    while (stack.isNotEmpty()) {
        val current = stack.removeFirst()

        if (discover.contains(current).not()) {
            discover.add(current)

            for (n in graph[current] ?: emptyList()) {
                stack.add(n)
            }
        }
    }

    return discover
}