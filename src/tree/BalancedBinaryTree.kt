package tree

import kotlin.math.absoluteValue

fun main() {
    val case1 = listOf(3, 9, 20, null, null, 15, 7).toTreeNode()
    val case2 = listOf(1, 2, 2, 3, 3, null, null, 4, 4).toTreeNode()
    val case3 = listOf<Int>().toTreeNode()
    val case4 = listOf(1, 2, null, 3, null, 4, null, 5).toTreeNode()

    println(isBalanced(case1))
    println(isBalanced(case2))
    println(isBalanced(case3))
    println(isBalanced(case4))
}

private var isBalanced = true

private fun isBalanced(root: TreeNode?): Boolean {
    if (root == null) return true

    isBalanced = true
    calculateHeight(root)

    return  isBalanced
}

private fun calculateHeight(root: TreeNode?): Int {
    if (root == null) return 0

    val left = calculateHeight(root.left)
    val right = calculateHeight(root.right)

    if ((left - right).absoluteValue > 1) isBalanced = false

    return 1 + maxOf(left, right)
}

// https://leetcode.com/problems/balanced-binary-tree/description/