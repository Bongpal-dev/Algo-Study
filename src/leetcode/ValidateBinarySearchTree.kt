package leetcode

import tree.TreeNode
import tree.toTreeNode

fun main() {
    val root1 = listOf(2, 1, 3).toTreeNode()
    val root2 = listOf(5, 1, 4, null, null, 3, 6).toTreeNode()

    println(isValidBST(root1))
    println(isValidBST(root2))
}

private fun isValidBST(root: TreeNode?): Boolean {
    if(root == null) return true

    return valid(root, Long.MIN_VALUE, Long.MAX_VALUE)
}

private fun valid(root: TreeNode?, min: Long, max: Long): Boolean {
    if(root == null) return true

    if(root.`val` <= min || root.`val` >= max) return false

    return valid(root.left, min, root.`val`.toLong()) && valid(root.right, root.`val`.toLong(), max)
}

// https://leetcode.com/problems/validate-binary-search-tree/description/