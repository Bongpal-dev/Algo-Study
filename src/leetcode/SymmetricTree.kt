package leetcode

import tree.TreeNode
import tree.toTreeNode

fun main() {
    val root1 = listOf(1,2,2,3,4,4,3).toTreeNode()
    val root2 = listOf(1,2,2,null,3,null,3).toTreeNode()

    println(isSymmetric(root1))
    println(isSymmetric(root2))
}

private fun isSymmetric(root: TreeNode?): Boolean {
    val queue = ArrayList<N>()

    queue.add(N(root?.left, root?.right))

    while(queue.isNotEmpty()) {
        val (left, right) = queue.removeFirst()

        if(left == null && right == null) continue
        if(left == null || right == null) return false
        if(left.`val` != right.`val`) return false

        queue.add(N(left.left, right.right))
        queue.add(N(left.right, right.left))
    }

    return true
}

private data class N(
    val left: TreeNode?,
    val right: TreeNode?
)

// https://leetcode.com/problems/symmetric-tree/description/