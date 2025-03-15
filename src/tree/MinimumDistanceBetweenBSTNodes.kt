package tree

import com.sun.source.tree.ImportTree
import java.util.TreeSet
import kotlin.math.absoluteValue

fun main() {
    val root1 = listOf(4, 2, 6, 1, 3).toTreeNode()
    val root2 = listOf(1, 0, 48, null, null, 12, 49).toTreeNode()
    val root3 = listOf(27, null, 34, null, 58, 50, null, 44).toTreeNode()

    println(minDiffInBST(root1))
    println(minDiffInBST(root2))
    println(minDiffInBST(root3))
}

private fun minDiffInBST(root: TreeNode?): Int {
    val visited = mutableSetOf<Int>()

    return setNode(root, visited)
}

private fun setNode(root: TreeNode?, visited: MutableSet<Int>): Int {
    if (root == null) return Int.MAX_VALUE

    var min = Int.MAX_VALUE
    val left = setNode(root.left, visited)
    val right = setNode(root.right, visited)

    visited.forEach { min = minOf(min, (root.`val` - it).absoluteValue) }
    visited.add(root.`val`)

    return minOf(min, left, right)
}

// https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/