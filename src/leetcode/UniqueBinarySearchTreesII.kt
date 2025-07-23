package leetcode

import tree.TreeNode
import tree.toList

fun main() {
    val n1 = 3
    val n2 = 1

    println(generateTrees(n1).map { it.toList() })
    println(generateTrees(n2).map { it.toList() })
}

private fun generateTrees(n: Int): List<TreeNode?> {
    return when (n) {
        0 -> emptyList()
        1 -> listOf(TreeNode(1))
        else -> generate(1, n)
    }
}

private fun generate(s: Int, e: Int): List<TreeNode?> {
    if (s > e) return listOf(null)

    val result = mutableListOf<TreeNode?>()

    for (i in s..e) {
        val left = generate(s, i - 1)
        val right = generate(i + 1, e)

        for(l in left) {
            for(r in right) {
                val root = TreeNode(i)

                root.left = l
                root.right = r
                result += root
            }
        }
    }

    return result
}

// https://leetcode.com/problems/unique-binary-search-trees-ii/description/