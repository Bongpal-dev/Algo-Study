package leetcode

import tree.TreeNode
import tree.toList
import tree.toTreeNode

fun main() {
    val root1 = listOf(1, 2, 5, 3, 4, null, 6).toTreeNode()
    val root2 = listOf<Int>().toTreeNode()
    val root3 = listOf(0).toTreeNode()

    flatten(root1)
    flatten(root2)
    flatten(root3)

    println(root1.toList())
    println(root2.toList())
    println(root3.toList())
}

private fun flatten(root: TreeNode?): Unit {
    generate(root)
}

private fun generate(node: TreeNode?): TreeNode? {
    if (node == null) return null
    if (node.left == null && node.right == null) return node

    val left = generate(node.left)
    val right = generate(node.right)

    left?.let {
        it.right = node.right
        node.right = node.left
        node.left = null
    }

    return right ?: left
}

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/