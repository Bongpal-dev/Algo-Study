package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "5\n-1 0 0 1 1\n2",
        "5\n-1 0 0 1 1\n1",
        "5\n-1 0 0 1 1\n0",
        "9\n-1 0 0 2 2 4 4 6 6\n4",
        "4\n-1 0 0 0\n2",
        "6\n-1 0 0 5 5 2\n2"
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
    val p = readLine().split(" ").map { it.toInt() }
    val d = readLine().toInt()
    val tree = List(n) { mutableListOf<Int>() }
    var root = -1

    p.forEachIndexed { i, v ->
        if (v == -1) {
            root = i
        } else {
            tree[v] += i
        }
    }

    BooleanArray(n).also { deleteNode(d, tree, it) }.let { deleted ->
        println(if (deleted[root]) 0 else countLeaf(root, tree, deleted))
    }
}

private fun deleteNode(i: Int, tree: List<List<Int>>, deleted: BooleanArray) {
    deleted[i] = true
    tree[i].forEach { deleteNode(it, tree, deleted) }
}

private fun countLeaf(i: Int, tree: List<List<Int>>, deleted: BooleanArray): Int {
    return when {
        deleted[i] -> 0
        tree[i].all { deleted[it] } -> 1
        else -> tree[i].sumOf { countLeaf(it, tree, deleted) }
    }
}

// https://www.acmicpc.net/problem/1068