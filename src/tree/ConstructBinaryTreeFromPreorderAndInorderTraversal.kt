package tree

fun main() {
    val (preorder1, inorder1) = intArrayOf(3, 9, 20, 15, 7) to intArrayOf(9, 3, 15, 20, 7)
    val (preorder2, inorder2) = intArrayOf(-1) to intArrayOf(-1)

    println(buildTree(preorder1, inorder1).toList())
    println(buildTree(preorder2, inorder2).toList())
}

private fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    return build(preorder.toMutableList(), inorder.toList())
}

private fun build(preorder: MutableList<Int>, inorder: List<Int>): TreeNode? {
    if (inorder.isEmpty()) return null

    val rootValue = preorder.removeFirst()
    val i = inorder.indexOf(rootValue)

    val root = TreeNode(rootValue)

    root.left = build(preorder, inorder.subList(0, i))
    root.right = build(preorder, inorder.subList(i + 1, inorder.size))

    return root
}

// http://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/