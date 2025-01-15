package linkedlist

fun main() {
    val case1 = ListNode(1).apply { add(2); add(3); add(4); add(5) }
    val case2 = ListNode(1).apply { add(2); }

    println(reverseList(case1)?.joinToString())
    println(reverseList(case2)?.joinToString())
    println(reverseList(null)?.joinToString())
}

private fun reverseList(head: ListNode?): ListNode? {
    var next: ListNode? = null
    var current: ListNode? = head
    var prev: ListNode?

    while (current != null) {
        prev = current.next
        current.next = next
        next = current
        current = prev
    }

    return next
}

// https://leetcode.com/problems/reverse-linked-list/description/