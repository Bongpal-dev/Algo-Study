package leetcode

import linkedlist.ListNode
import linkedlist.toListNode

fun main() {
    val head1 = listOf(1, 2, 3, 3, 4, 4, 5).toListNode()
    val head2 = listOf(1, 1, 1, 2, 3).toListNode()

    println(deleteDuplicates(head1)?.joinToString())
    println(deleteDuplicates(head2)?.joinToString())
}

private fun deleteDuplicates(head: ListNode?): ListNode? {
    val answer = ListNode(0)
    var aHead: ListNode? = answer
    var node: ListNode? = head
    var isSeen = false

    while (node != null) {
        if (node.next != null && node.`val` == node.next?.`val`) {
            isSeen = true
        } else {
            if (!isSeen) {
                aHead?.next = node
                aHead = aHead?.next
            }
            isSeen = false
        }
        node = node.next
    }
    aHead?.next = null

    return answer.next
}

// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/