package leetcode

import tree.TreeNode
import tree.toTreeNode

fun main() {
    val (root1, targetSum1) = listOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1).toTreeNode() to 22
    val (root2, targetSum2) = listOf(1, 2, 3).toTreeNode() to 5
    val (root3, targetSum3) = listOf(1, 2).toTreeNode() to 0

    println(pathSum(root1, targetSum1))
    println(pathSum(root2, targetSum2))
    println(pathSum(root3, targetSum3))
}

private fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    val answer = mutableListOf<List<Int>>()

    find(root, 0, targetSum, mutableListOf(), answer)

    return answer
}

private fun find(
    node: TreeNode?,
    s: Int,
    t: Int,
    path: MutableList<Int>,
    answer: MutableList<List<Int>>
) {
    if (node == null) return

    val currentSum = s + node.`val`

    path += node.`val`

    if (node.left == null && node.right == null && currentSum == t) {
        answer += path.toList()
    } else {
        find(node.left, currentSum, t, path, answer)
        find(node.right, currentSum, t, path, answer)
    }

    path.removeLast()
}

// https://leetcode.com/problems/path-sum-ii/description/