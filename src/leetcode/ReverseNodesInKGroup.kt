package leetcode

import linkedlist.ListNode

fun main() {
    val (head1, k1) = ListNode(1).apply { add(2); add(3);add(4);add(5) } to 2
    val (head2, k2) = ListNode(1).apply { add(2); add(3);add(4);add(5) } to 3
    val (head3, k3) = ListNode(1).apply { add(2); } to 2

    println(reverseKGroup(head1, k1)?.joinToString())
    println(reverseKGroup(head2, k2)?.joinToString())
    println(reverseKGroup(head3, k3)?.joinToString())
}

private fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    val head = ListNode(0).apply { next = head }
    var current = head.next
    var prev: ListNode? = head
    val stack = arrayListOf<ListNode>()

    while (current != null) {
        stack.add(current)
        current = current.next

        if (stack.size == k) {
            val reverse = ListNode(0)
            var node: ListNode? = reverse

            while (stack.isNotEmpty()) {
                node?.next = stack.removeLast()
                node = node?.next
            }
            node?.next = current
            prev?.next = reverse.next
            prev = node
        }
    }

    return head.next
}

// https://leetcode.com/problems/reverse-nodes-in-k-group/description/