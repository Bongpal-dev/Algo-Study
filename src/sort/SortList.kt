package sort

import linkedlist.ListNode
import linkedlist.toListNode

fun main() {
    val head1 = listOf(4, 2, 1, 3).toListNode()
    val head2 = listOf(-1, 5, 3, 4, 0).toListNode()
    val head3 = listOf<Int>().toListNode()

    println(sortList(head1)?.joinToString())
    println(sortList(head2)?.joinToString())
    println(sortList(head3)?.joinToString())
}

private fun sortList(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    val mid = head.getMid()
    val next = mid?.next

    mid?.next = null

    val left = sortList(head)
    val right = sortList(next)

    return merge(left, right)
}

private fun merge(list1: ListNode?, list2: ListNode?): ListNode? {
    val root = ListNode(0)
    var currentNode = root
    var l1 = list1
    var l2 = list2

    while (l1 != null && l2 != null) {
        if (l1.`val` < l2.`val`) {
            currentNode.next = l1
            l1 = l1.next
        } else {
            currentNode.next = l2
            l2 = l2.next
        }
        currentNode = currentNode.next!!
    }
    currentNode.next = l1 ?: l2

    return root.next
}

private fun ListNode?.getMid(): ListNode? {
    var l = this
    var r = this?.next

    while (l != null && r?.next != null) {
        l = l.next
        r = r.next?.next
    }

    return l
}

// https://leetcode.com/problems/sort-list/description/