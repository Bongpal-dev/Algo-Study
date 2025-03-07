package tree

fun main() {
    val (root11, root21) = listOf(1, 3, 2, 5).toTreeNode() to listOf(2, 1, 3, null, 4, null, 7).toTreeNode()
    val (root12, root22) = listOf(1).toTreeNode() to listOf(1, 2).toTreeNode()

    println(mergeTrees(root11, root21).toList())
    println(mergeTrees(root12, root22).toList())
}

private fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    when {
        root1 != null && root2 == null -> return root1
        root1 == null && root2 != null -> return root2
        root1 == null && root2 == null -> return null
    }

    return generate(root1, root2)
}

private fun generate(root1: TreeNode?, root2: TreeNode?): TreeNode? {
    if(root1 == null && root2 == null) return null

    val v1 = root1?.`val` ?: 0
    val v2 = root2?.`val` ?: 0
    val current = TreeNode(v1 + v2)

    current.left = generate(root1?.left, root2?.left)
    current.right = generate(root1?.right, root2?.right)

    return current
}

// https://leetcode.com/problems/merge-two-binary-trees/description/