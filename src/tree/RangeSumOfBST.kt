package tree

fun main() {
    val root1 = listOf(10, 5, 15, 3, 7, null, 18).toTreeNode()
    val (low1, high1) = 7 to 15
    val root2 = listOf(10, 5, 15, 3, 7, 13, 18, 1, null, 6).toTreeNode()
    val (low2, high2) = 6 to 10

    println(rangeSumBST(root1, low1, high1))
    println(rangeSumBST(root2, low2, high2))
}

private fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    if (root == null) return 0

    val add = if (root.`val` in low .. high) root.`val` else 0
    val left = rangeSumBST(root.left, low, high)
    val right = rangeSumBST(root.right, low, high)

    return add + left + right
}

// https://leetcode.com/problems/range-sum-of-bst/description/