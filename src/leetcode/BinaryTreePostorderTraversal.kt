package leetcode

import tree.TreeNode
import tree.toTreeNode

fun main() {
    val root1 = listOf(1, null, 2, 3).toTreeNode()
    val root2 = listOf(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9).toTreeNode()
    val root3 = listOf<Int>().toTreeNode()
    val root4 = listOf(1).toTreeNode()

    println(postorderTraversal(root1))
    println(postorderTraversal(root2))
    println(postorderTraversal(root3))
    println(postorderTraversal(root4))
}

private fun postorderTraversal(root: TreeNode?): List<Int> {
    val answer = mutableListOf<Int>()

    generate(root, answer)

    return answer
}

private fun generate(node: TreeNode?, answer: MutableList<Int>) {
    if (node == null) return

    node.left?.let { generate(it, answer) }
    node.right?.let { generate(it, answer) }

    answer += node.`val`
}

// https://leetcode.com/problems/binary-tree-postorder-traversal/description/