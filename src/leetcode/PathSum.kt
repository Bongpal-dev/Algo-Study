package leetcode

import tree.TreeNode
import tree.toTreeNode

fun main() {
    val (root1, targetSum1) = listOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1).toTreeNode() to 22
    val (root2, targetSum2) = listOf(1, 2, 3).toTreeNode() to 5
    val (root3, targetSum3) = listOf<Int?>().toTreeNode() to 0

    println(hasPathSum(root1, targetSum1))
    println(hasPathSum(root2, targetSum2))
    println(hasPathSum(root3, targetSum3))
}

private fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    return find(root, 0, targetSum)
}

private fun find(node: TreeNode?, sum: Int, target: Int): Boolean {
    if (node == null) return false

    val nSum = sum + node.`val`

    if (node.left == null && node.right == null) {
        return nSum == target
    }
    return find(node.left, nSum, target) || find(node.right, nSum, target)
}

// https://leetcode.com/problems/path-sum/description/