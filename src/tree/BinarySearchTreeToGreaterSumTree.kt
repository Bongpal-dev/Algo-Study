package tree

fun main() {
    val root1 = listOf(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8).toTreeNode()
    val root2 = listOf(0, null, 1).toTreeNode()

    println(bstToGst(root1).toList())
    println(bstToGst(root2).toList())
}

private fun bstToGst(root: TreeNode?): TreeNode? {
    var sum = 0

    fun convert(root: TreeNode?) {
        if (root == null) return

        convert(root.right)
        sum += root.`val`
        root.`val` = sum
        convert(root.left)
    }

    convert(root)

    return root
}

// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/