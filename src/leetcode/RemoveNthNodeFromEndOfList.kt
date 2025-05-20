package leetcode

import linkedlist.ListNode

fun main() {
    val (head1, n1) = ListNode(1).apply { add(2); add(3); add(4); add(5); } to 2
    val (head2, n2) = ListNode(1) to 1
    val (head3, n3) = ListNode(1).apply { add(2) } to 1

    println(removeNthFromEnd(head1, n1)?.joinToString())
    println(removeNthFromEnd(head2, n2)?.joinToString())
    println(removeNthFromEnd(head3, n3)?.joinToString())
}

private val ListNode?.size get() = this.countSize()

private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    return head.removeAt(head.size - n)
}

private fun ListNode?.countSize(): Int {
    var current = this
    var count = 0

    while (current != null) {
        count++
        current = current.next
    }

    return count
}

private fun ListNode?.removeAt(index: Int): ListNode? {
    val head = ListNode(0).apply { next = this }
    var current = head.next
    var i = 0

    head.next = this

    while (current != null) {
        if (i == index) {
            current.next = current.next?.next
            break
        }
        current = current.next
        i++
    }

    return head.next
}

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/