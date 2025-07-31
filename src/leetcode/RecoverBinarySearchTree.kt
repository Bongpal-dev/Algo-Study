package leetcode

import tree.TreeNode
import tree.toList
import tree.toTreeNode

fun main() {
    val root1 = listOf(1, 3, null, null, 2).toTreeNode()
    val root2 = listOf(3, 1, 4, null, null, 2).toTreeNode()

    recoverTree(root1)
    recoverTree(root2)

    println(root1.toList())
    println(root2.toList())
}

private fun recoverTree(root: TreeNode?): Unit {
    if (root == null) return

    root.traversal().let { list ->
        val (l, r) = list.findMistake()

        return root.swapNode(list[l], list[r])
    }
}

private fun TreeNode?.traversal(): List<Int> {
    if (this == null) return emptyList()

    return this.left.traversal() + listOf(this.`val`) + this.right.traversal()
}

private fun List<Int>.findMistake(): Pair<Int, Int> {
    var selectedL = false
    var l = 0
    var r = 0

    for (i in 0..this.size - 2) {
        if (this[i] <= this[i + 1]) continue

        if (selectedL.not()) {
            l = i
            r = i + 1
            selectedL = true
        } else {
            r = i + 1
        }
    }

    return l to r
}

private fun TreeNode?.swapNode(a: Int, b: Int) {
    if (this == null) return

    when (this.`val`) {
        a -> this.`val` = b
        b -> this.`val` = a
    }

    this.left.swapNode(a, b)
    this.right.swapNode(a, b)
}

// https://leetcode.com/problems/recover-binary-search-tree/description/