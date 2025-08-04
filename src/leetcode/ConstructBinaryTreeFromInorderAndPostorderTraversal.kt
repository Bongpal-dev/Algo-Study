package leetcode

import tree.TreeNode
import tree.toList

fun main() {
    val (inorder1, postorder1) = intArrayOf(9, 3, 15, 20, 7) to intArrayOf(9, 15, 7, 20, 3)
    val (inorder2, postorder2) = intArrayOf(-1) to intArrayOf(-1)

    println(buildTree(inorder1, postorder1).toList())
    println(buildTree(inorder2, postorder2).toList())
}

private fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
    if (inorder.isEmpty() || postorder.isEmpty()) return null

    val root = TreeNode(postorder.last())
    val iIndex = inorder.indexOf(root.`val`)

    val (lI, rI) = inorder.copyOfRange(0, iIndex) to inorder.copyOfRange(iIndex + 1, inorder.size)
    val (lP, rP) = postorder.copyOfRange(0, iIndex) to postorder.copyOfRange(iIndex, postorder.size - 1)

    root.left = buildTree(lI, lP)
    root.right = buildTree(rI, rP)

    return root
}

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/