package leetcode

import linkedlist.ListNode
import linkedlist.toListNode

fun main() {
    val (head1, x1) = listOf(1,4,3,2,5,2).toListNode() to 3
    val (head2, x2) = listOf(2, 1).toListNode() to 2

    println(partition(head1, x1)?.joinToString())
    println(partition(head2, x2)?.joinToString())
}

private fun partition(head: ListNode?, x: Int): ListNode? {
    val under = ListNode(0)
    val over = ListNode(0)

    var uNode: ListNode? = under
    var oNode: ListNode? = over
    var cNode: ListNode? = head

    while(cNode != null) {
        if(cNode.`val` < x) {
            uNode?.next = cNode
            uNode = uNode?.next
        } else {
            oNode?.next = cNode
            oNode = oNode?.next
        }
        cNode = cNode.next
    }

    oNode?.next = null
    uNode?.next = over.next

    return under.next
}

// https://leetcode.com/problems/partition-list/description/