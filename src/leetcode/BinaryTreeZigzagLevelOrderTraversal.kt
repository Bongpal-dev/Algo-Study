package leetcode

import tree.TreeNode
import tree.toTreeNode

fun main() {
    val root1 = listOf(3, 9, 20, null, null, 15, 7).toTreeNode()
    val root2 = listOf(1).toTreeNode()
    val root3 = listOf<Int>().toTreeNode()
    val root4 = listOf(1, 2, 3, 4, null, null, 5).toTreeNode()

    println(zigzagLevelOrder(root1))
    println(zigzagLevelOrder(root2))
    println(zigzagLevelOrder(root3))
    println(zigzagLevelOrder(root4))
}

private fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    if (root == null) return emptyList()

    val answer = mutableListOf<MutableList<Int>>()
    val queue = ArrayDeque<NodeZ>()
    var lastDepth = -1

    queue += NodeZ(
        node = root,
        depth = 0
    )

    while (queue.isNotEmpty()) {
        val c = queue.removeFirst()

        if (c.depth != lastDepth) {
            answer += mutableListOf(c.node.`val`)
            lastDepth = c.depth
        } else {
            if (lastDepth % 2 == 0) {
                answer[lastDepth] += c.node.`val`
            } else {
                answer[lastDepth].add(0, c.node.`val`)
            }
        }

        c.node.left?.let { l -> queue.add(NodeZ(l, c.depth + 1)) }
        c.node.right?.let { l -> queue.add(NodeZ(l, c.depth + 1)) }
    }

    return answer
}

private data class NodeZ(
    val node: TreeNode,
    val depth: Int
)

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/