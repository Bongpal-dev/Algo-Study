package tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun List<Int?>.toTreeNode(): TreeNode {
    val root = TreeNode(this.first()!!)
    val queue = mutableListOf<TreeNode>()
    var i = 1

    queue.add(root)

    while (i <= this.lastIndex) {
        val current = queue.removeFirst()

        this[i++]?.let { current.left = TreeNode(it).also { t -> queue.add(t) } }

        if (i > this.lastIndex) break

        this[i++]?.let { current.right = TreeNode(it).also { t -> queue.add(t) } }
    }

    return root
}