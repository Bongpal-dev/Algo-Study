package sort

import linkedlist.ListNode
import linkedlist.toListNode

fun main() {
    val head1 = listOf(4, 2, 1, 3).toListNode()
    val head2 = listOf(-1, 5, 3, 4, 0).toListNode()

    println(insertionSortList(head1)?.joinToString())
    println(insertionSortList(head2)?.joinToString())
}

private fun insertionSortList(head: ListNode?): ListNode? {
    if (head == null) return null

    val result = ListNode(Int.MIN_VALUE)
    var nextTarget = head

    while (nextTarget != null) {
        val current = nextTarget
        var resultNode: ListNode? = result
        var prevResult: ListNode? = null

        nextTarget = nextTarget.next

        while (resultNode != null && resultNode.`val` <  current.`val`) {
            prevResult = resultNode
            resultNode = resultNode.next
        }

        current.next = prevResult?.next
        prevResult?.next = current
    }

    return result.next
}

// https://leetcode.com/problems/insertion-sort-list/description/