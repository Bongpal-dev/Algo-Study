package tree

fun main() {
    val case1 = listOf(3, 9, 20, null, null, 15, 7).toTreeNode()
    val case2 = listOf(1, null, 2).toTreeNode()
    val case3 = listOf(1, 2, null, 3, null, 4, null, 5).toTreeNode()
    val case4 = listOf(1,2,3,4,null,null,5).toTreeNode()

    println(maxDepth(case1))
    println(maxDepth(case2))
    println(maxDepth(case3))
    println(maxDepth(case4))
}

private fun maxDepth(root: TreeNode?) = findDepth(root)

private fun findDepth(node: TreeNode?): Int {
    if (node == null) return 0

    return 1 + maxOf(findDepth(node.left), findDepth(node.right))
}

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/