package tree

fun main() {
    val codec = Codec()
    val root1 = listOf(1, 2, 3, null, null, 4, 5).toTreeNode()
    val root2 = listOf<Int>().toTreeNode()

    println(codec.serialize(root1))
    println(codec.serialize(root2))
}

private class Codec() {
    fun serialize(root: TreeNode?): String {
        if (root == null) return ""

        val queue = mutableListOf<TreeNode?>()
        val result = mutableListOf<Int?>()

        queue.add(root)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()

            if (current == null) {
                result.add(null)
                continue
            } else {
                result.add(current.`val`)
            }
            queue.add(current.left)
            queue.add(current.right)
        }

        while (result.last() == null) {
            result.removeLast()
        }

        return result.toString()
    }

    fun deserialize(data: String): TreeNode? {
        if (data.isBlank()) return null

        val list = data.removePrefix("[").removeSuffix("]").split(", ").map { it.toIntOrNull() }
        val queue = mutableListOf<TreeNode>()
        val root = TreeNode(list.first() ?: 0)
        var i = 1

        queue.add(root)

        while (i < list.size) {
            val current = queue.removeFirst()

            if (list[i] == null) {
                current.left = null
            } else {
                current.left = TreeNode(list[i]!!).also { queue.add(it) }
            }
            i++

            if (i > list.lastIndex) break

            if (list[i] == null) {
                current.right = null
            } else {
                current.right = TreeNode(list[i]!!).also { queue.add(it) }
            }
            i++
        }

        return root
    }
}

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/