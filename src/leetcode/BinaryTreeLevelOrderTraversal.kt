package leetcode

import tree.TreeNode
import tree.toTreeNode
import java.util.*

fun main() {
    val root1 = listOf(3, 9, 20, null, null, 15, 7).toTreeNode()
    val root2 = listOf(1).toTreeNode()
    val root3 = listOf<Int>().toTreeNode()

    println(levelOrder(root1))
    println(levelOrder(root2))
    println(levelOrder(root3))
}

private fun levelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val answer = mutableListOf<MutableList<Int>>()
    val queue = ArrayDeque<NodeL>()
    var currentLevel = -1

    queue += NodeL(root, 0)

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()

        if (current.level == currentLevel) {
            answer[current.level] += current.node.`val`
        } else {
            answer += mutableListOf(current.node.`val`)
            currentLevel = current.level
        }

        current.node.left?.let { l -> queue.add(NodeL(l, current.level + 1)) }
        current.node.right?.let { r -> queue.add(NodeL(r, current.level + 1)) }
    }

    return answer
}

private data class NodeL(
    val node: TreeNode,
    val level: Int
)

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/