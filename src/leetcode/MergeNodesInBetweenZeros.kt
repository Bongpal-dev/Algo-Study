package leetcode

import linkedlist.ListNode
import linkedlist.toListNode

fun main() {
    val head1 = listOf(0, 3, 1, 0, 4, 5, 2, 0).toListNode()
    val head2 = listOf(0, 1, 0, 3, 0, 2, 2, 0).toListNode()

    println(mergeNodes(head1)?.joinToString())
    println(mergeNodes(head2)?.joinToString())
}

private fun mergeNodes(head: ListNode?): ListNode? {
    val ans = ListNode(0)
    var ansNode: ListNode? = ans
    var node = head
    var c = 0

    while(node != null) {
        if(c > 0 && node.`val` == 0) {
            ansNode?.next = ListNode(c)
            ansNode = ansNode?.next
            c = 0
        } else {
            c += node.`val`
        }

        node = node.next
    }

    return ans.next
}

// https://leetcode.com/problems/merge-nodes-in-between-zeros/description/