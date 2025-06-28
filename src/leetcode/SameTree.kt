package leetcode

import tree.TreeNode
import tree.toTreeNode

fun main() {
    val (p1, q1) = listOf(1, 2, 3).toTreeNode() to listOf(1, 2, 3).toTreeNode()
    val (p2, q2) = listOf(1, 2).toTreeNode() to listOf(1, null, 3).toTreeNode()
    val (p3, q3) = listOf(1, 2, 1).toTreeNode() to listOf(1, 1, 2).toTreeNode()

   println(isSameTree(p1, q1))
   println(isSameTree(p2, q2))
   println(isSameTree(p3, q3))
}

private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if(p == null && q == null) return true
    if(p == null || q == null) return false

    val left = isSameTree(p.left, q.left)
    val right = isSameTree(p.right, q.right)
    val current = p.`val` == q.`val`

    return left && right && current
}

// https://leetcode.com/problems/same-tree/description/