package tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    val height get() = calculateHeight(this)

    private fun calculateHeight(node: TreeNode?): Int {
        if (node == null) return 0

        return 1 + maxOf(calculateHeight(node.left), calculateHeight(node.right))
    }
}

fun List<Int?>.toTreeNode(): TreeNode? {
    if (this.isEmpty()) return null

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

fun TreeNode?.toList(): List<Int?> {
    if (this == null) return emptyList()

    val result = mutableListOf<Int?>()
    val queue = mutableListOf<TreeNode?>()

    queue.add(this)

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()

        if (current != null) {
            result.add(current.`val`)
            queue.add(current.left)
            queue.add(current.right)
        } else {
            result.add(null)
        }
    }

    while (result.isNotEmpty() && result.last() == null) {
        result.removeLast()
    }

    return result
}