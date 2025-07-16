package leetcode

import linkedlist.ListNode
import linkedlist.toListNode

fun main() {
    listOf(
        listOf(3, 2, 0, -4).toListNode() to 1,
        listOf(1, 2).toListNode() to 0,
        listOf(1).toListNode() to -1
    ).forEach { (head, pos) ->
        if (pos >= 0) {
            var cycleNode = head

            repeat(pos) { cycleNode = cycleNode?.next }

            var tail = head

            while (tail?.next != null) tail = tail.next

            tail?.next = cycleNode
        }
        println(hasCycle(head))
    }
}

private fun hasCycle(head: ListNode?): Boolean {
    val set = mutableSetOf<ListNode>()
    var node: ListNode? = head

    while (node != null) {
        if (node in set) return true

        set += node
        node = node.next
    }

    return false
}

// https://leetcode.com/problems/linked-list-cycle/description/