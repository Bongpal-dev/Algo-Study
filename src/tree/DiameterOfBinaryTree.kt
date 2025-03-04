package tree

fun main() {
    val case1 = listOf(1, 2, 3, 4, 5).toTreeNode()
    val case2 = listOf(1, 2).toTreeNode()
    val case3 = listOf(2, 1, 4, 3, null, 5).toTreeNode()
    val case4 = listOf(4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6,null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2).toTreeNode()

    println(diameterOfBinaryTree(case1))
    println(diameterOfBinaryTree(case2))
    println(diameterOfBinaryTree(case3))
    println(diameterOfBinaryTree(case4))
}

private var diameter = 0

private fun diameterOfBinaryTree(root: TreeNode?): Int {
    if (root?.left == null && root?.right == null) return 0

    diameter = 0
    findLongestRoot(root)

    return diameter
}

private fun findLongestRoot(root: TreeNode?): Int {
    if (root == null) return 0

    val left = findLongestRoot(root.left)
    val right = findLongestRoot(root.right)

    diameter = maxOf(diameter, left + right)

    return 1 + maxOf(left, right)
}

// https://leetcode.com/problems/diameter-of-binary-tree/description/