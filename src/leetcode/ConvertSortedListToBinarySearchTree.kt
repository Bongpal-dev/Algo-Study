package leetcode

import linkedlist.ListNode
import linkedlist.toListNode
import tree.TreeNode
import tree.toList

fun main() {
    val head1 = listOf(-10, -3, 0, 5, 9).toListNode()
    val head2 = listOf<Int>().toListNode()

    println(sortedListToBST(head1).toList())
    println(sortedListToBST(head2).toList())
}

private fun sortedListToBST(head: ListNode?): TreeNode? {
    if (head == null) return null

    return generate(head.toList())
}

private fun generate(list: List<Int>): TreeNode? {
    if (list.isEmpty()) return null
    if (list.size == 1) return TreeNode(list[0])

    val mid = list.size / 2
    val root = TreeNode(list[mid])

    root.left = generate(list.subList(0, mid))
    root.right = generate(list.subList(mid + 1, list.size))

    return root
}

private fun ListNode.toList(): List<Int> {
    val result = mutableListOf<Int>()
    var n: ListNode? = this

    while (n != null) {
        result += n.`val`
        n = n.next
    }

    return result
}

// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/