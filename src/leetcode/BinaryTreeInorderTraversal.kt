package leetcode

import tree.TreeNode
import tree.toTreeNode

fun main() {
    val root1 = listOf(1, null, 2, 3).toTreeNode()
    val root2 = listOf(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9).toTreeNode()
    val root3 = listOf<Int>().toTreeNode()
    val root4 = listOf(1).toTreeNode()

    println(inorderTraversal(root1))
    println(inorderTraversal(root2))
    println(inorderTraversal(root3))
    println(inorderTraversal(root4))
}

private fun inorderTraversal(root: TreeNode?): List<Int> {
    val answer = mutableListOf<Int>()

    if (root == null) return emptyList()

    read(root, answer)

    return answer
}

private fun read(root: TreeNode, answer: MutableList<Int>) {
    if (root.left == null && root.right == null) {
        answer += root.`val`
        return
    }

    root.left?.let { read(it, answer) }
    answer += root.`val`
    root.right?.let { read(it, answer) }
}

// https://leetcode.com/problems/binary-tree-inorder-traversal/description/