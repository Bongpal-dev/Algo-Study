package linkedlist

fun main() {
    val case1 = ListNode(1).apply { add(2); add(3); add(4); add(5) }
    val case2 = ListNode(5)
    val case3 = ListNode(1).apply { add(2) }
    val case4 = ListNode(1).apply { add(2); add(3) }
    val case5 = ListNode(1).apply { add(2); add(3) }

    println(reverseBetween(case1, 2, 4)?.joinToString())
    println(reverseBetween(case2, 1, 1)?.joinToString())
    println(reverseBetween(case3, 1, 2)?.joinToString())
    println(reverseBetween(case4, 1, 3)?.joinToString())
    println(reverseBetween(case5, 3, 3)?.joinToString())
}

private fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    if (head?.next == null) return head

    val answer = ListNode(0)
    var headNode = head
    var index = 1
    var beforeLeft: ListNode? = null
    var afterRight: ListNode? = null
    var reverse:ListNode? = null
    var next: ListNode? = null
    var prev: ListNode? = null

    if (left > 1) answer.next = head


    while (headNode != null) {
        if (index == left -1) beforeLeft = headNode

        if (index == left) afterRight = headNode

        if (index in left ..right) {
            reverse = headNode
            next = headNode.next
            reverse.next = prev
            prev = reverse
            headNode = next
        } else {
            headNode = headNode.next
        }
        index++
    }
    beforeLeft?.next = reverse
    afterRight?.next = next

    return if (answer.next == null) reverse else answer.next
}

// https://leetcode.com/problems/reverse-linked-list-ii/description/