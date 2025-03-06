package tree

fun main() {
    val case1 = listOf(4, 2, 7, 1, 3, 6, 9).toTreeNode()
    val case2 = listOf(2, 1, 3).toTreeNode()
    val case3 = listOf<Int>().toTreeNode()

    println(invertTree(case1).toList())
    println(invertTree(case2).toList())
    println(invertTree(case3).toList())
}

private fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null

    val queue = mutableListOf<TreeNode?>()

    queue.add(root)

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst() ?: continue

        current.left = current.right.also { current.right = current.left }
        queue.add(current.left)
        queue.add(current.right)
    }

    return root
}

// https://leetcode.com/problems/invert-binary-tree/description/