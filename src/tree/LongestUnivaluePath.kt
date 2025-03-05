package tree

fun main() {
    val case1 = listOf(5, 4, 5, 1, 1, null, 5).toTreeNode()
    val case2 = listOf(1, 4, 5, 4, 4, null, 5).toTreeNode()
    val case3 = listOf(5, 4, 5, 1, 1, null, 5).toTreeNode()
    val case4 = listOf(1,null,1,1,1,1,1,1).toTreeNode()

    println(longestUnivaluePath(case1))
    println(longestUnivaluePath(case2))
    println(longestUnivaluePath(case3))
    println(longestUnivaluePath(case4))
}

private var maxValue = 0

private fun longestUnivaluePath(root: TreeNode?): Int {
    if (root == null) return 0

    maxValue = 0
    findPath(root)

    return maxValue
}

private fun findPath(root: TreeNode?): Int {
    if (root == null) return 0

    val left = findPath(root.left)
    val right = findPath(root.right)
    val leftValue = if (root.left?.`val` == root.`val`) left else 0
    val rightValue = if (root.right?.`val` == root.`val`) right else 0

    maxValue = maxOf(maxValue, leftValue + rightValue)

    return 1 + maxOf(leftValue, rightValue)
}

// https://leetcode.com/problems/longest-univalue-path/description/