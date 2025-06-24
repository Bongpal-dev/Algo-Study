package leetcode

import linkedlist.ListNode

fun main() {
    val head1 = ListNode(1).apply { add(1);add(2) }
    val head2 = ListNode(1).apply { add(1);add(2);add(3);add(3) }

    println(deleteDuplicates(head1)?.joinToString())
    println(deleteDuplicates(head2)?.joinToString())
}

private fun deleteDuplicates(head: ListNode?): ListNode? {
    if(head == null) return null

    var node = head

    while(node?.next != null) {
        if(node.`val` == node.next?.`val`) {
            node.next = node.next?.next
        } else {
            node = node.next
        }
    }

    return head
}

// http://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

/*
private fun deleteDuplicates(head: ListNode?): ListNode? {
    if(head == null) return null

    val answer = ListNode(0)
    var aNode: ListNode? = answer

    var cNode: ListNode? = head
    var n = -101

    while(cNode != null) {
        if(cNode.`val` != n) {
            aNode?.next = cNode
            n = cNode.`val`
            aNode = aNode?.next
        }

        val prev = cNode

        cNode = cNode.next
        prev.next = null
    }

    return answer.next
}
 */