package leetcode

import tree.TreeNode
import tree.toTreeNode

fun main() {
    val root1 = listOf(3, 9, 20, null, null, 15, 7).toTreeNode()
    val root2 = listOf(2, null, 3, null, 4, null, 5, null, 6).toTreeNode()
    val root3 = listOf(-9,-3,2,null,4,4,0,-6,null,-5).toTreeNode()

    println(minDepth(root1))
    println(minDepth(root2))
    println(minDepth(root3))
}

private fun minDepth(root: TreeNode?): Int {
    if(root == null) return 0

    val l = minDepth(root.left)
    val r = minDepth(root.right)

    if(l == 0) return r + 1
    if(r == 0) return l + 1

    return minOf(l, r) + 1
}

// https://leetcode.com/problems/minimum-depth-of-binary-tree/description/