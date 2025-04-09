package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "5\n4 0 1 1\n4 1 3 1\n4 2 5 1\n4 3 7 1",
        "2\n0 1 6 4",
        "3\n0 1 9 8\n1 2 9 8",
        "4\n2 3 6 8\n0 1 9 3\n3 0 7 5"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val graph = hashMapOf<Long, MutableList<Pair<Long, Fraction>>>()

    repeat(n - 1) {
        val (a, b, p, q) = readLine().split(" ").map { it.toLong() }

        graph.getOrPut(a) { mutableListOf() }.add(b to Fraction(q, p))
        graph.getOrPut(b) { mutableListOf() }.add(a to Fraction(p, q))
    }

    val child = LongArray(n)
    val mother = LongArray(n)
    val visited = BooleanArray(n)

    fun dfs(current: Int) {
        visited[current] = true

        for (n in graph[current.toLong()].orEmpty()) {
            val next = n.first.toInt()
            val fraction = n.second

            if (visited[next].not()) {
                child[next] = child[current] * fraction.child
                mother[next] = mother[current] * fraction.mother

                val g = gcd(child[next], mother[next])

                child[next] /= g
                mother[next] /= g
                dfs(next)
            }
        }
    }

    child[0] = 1
    mother[0] = 1
    dfs(0)

    val lcmV = mother.reduce { acc, m -> lcm(acc, m) }
    val result = LongArray(n) { i -> child[i] * lcmV / mother[i] }

    println(result.joinToString(" "))
}

private data class Fraction(val child: Long, val mother: Long)

private fun gcd(a: Long, b: Long): Long {
    return if (b == 0L) a else gcd(b, a % b)
}

private fun lcm(a: Long, b: Long): Long {
    return (a * b) / gcd(a, b)
}

// https://www.acmicpc.net/problem/1033