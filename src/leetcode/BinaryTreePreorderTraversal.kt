package leetcode

import tree.TreeNode
import tree.toTreeNode

fun main() {
    val root1 = listOf(1,null,2,3).toTreeNode()
    val root2 = listOf(1,2,3,4,5,null,8,null,null,6,7,9).toTreeNode()
    val root3 = listOf<Int>().toTreeNode()
    val root4 = listOf(1).toTreeNode()

    println(preorderTraversal(root1))
    println(preorderTraversal(root2))
    println(preorderTraversal(root3))
    println(preorderTraversal(root4))
}

private fun preorderTraversal(root: TreeNode?): List<Int> {
    val answer = mutableListOf<Int>()

    generate(root, answer)

    return answer
}

private fun generate(root: TreeNode?, answer: MutableList<Int>) {
    if(root == null) return

    answer += root.`val`
    generate(root.left, answer)
    generate(root.right, answer)
}

// https://leetcode.com/problems/binary-tree-preorder-traversal/description/