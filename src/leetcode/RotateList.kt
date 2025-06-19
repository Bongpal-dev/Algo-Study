package leetcode

import linkedlist.ListNode

fun main() {
    val (head1, k1) = ListNode(1).apply { add(2); add(3); add(4); add(5) } to 2
    val (head2, k2) = ListNode(0).apply { add(1); add(2); } to 4

    println(rotateRight(head1, k1)?.joinToString())
    println(rotateRight(head2, k2)?.joinToString())
}

private fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if(head == null) return null

    val size = head.getSize()
    val m = k % size

    if(m == 0) return head

    var i = 0

    var prev: ListNode? = null
    var node: ListNode? = head
    var result: ListNode? = null

    while (node != null) {
        if (size - i == m) {
            prev?.next = null
            result = node
        }

        prev = node
        node = node.next
        i++
    }
    prev?.next = head

    return result
}

private fun ListNode?.getSize(): Int {
    var node: ListNode? = this
    var result = 0

    while (node != null) {
        result++
        node = node.next
    }

    return result
}

// https://leetcode.com/problems/rotate-list/description/