package leetcode

import tree.TreeNode
import tree.toTreeNode

fun main() {
    val root1 = listOf(3, 9, 20, null, null, 15, 7).toTreeNode()
    val root2 = listOf(1).toTreeNode()
    val root3 = listOf<Int>().toTreeNode()

    println(levelOrderBottom(root1))
    println(levelOrderBottom(root2))
    println(levelOrderBottom(root3))
}

private fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val answer = mutableListOf<MutableList<Int>>()
    val queue = ArrayDeque<LNode>()
    var cDepth = -1

    queue += LNode(root, 0)

    while (queue.isNotEmpty()) {
        val c = queue.removeFirst()

        if (c.depth != cDepth) {
            answer.add(0, mutableListOf(c.node.`val`))
            cDepth = c.depth
        } else {
            answer[0] += c.node.`val`
        }

        c.node.left?.let { queue += LNode(it, c.depth + 1) }
        c.node.right?.let { queue += LNode(it, c.depth + 1) }
    }

    return answer
}

private data class LNode(
    val node: TreeNode,
    val depth: Int
)

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/