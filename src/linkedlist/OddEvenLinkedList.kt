package linkedlist

fun main() {
    val case1 = ListNode(1).apply { add(2); add(3); add(4); add(5) }
    val case2 = ListNode(2).apply { add(1); add(3); add(5); add(6); add(4); add(7) }

    println(oddEvenList(case1)?.joinToString())
    println(oddEvenList(case2)?.joinToString())
}

private fun oddEvenList(head: ListNode?): ListNode? {
    if (head == null) return null

    if (head.next == null) return head

    val answer = ListNode(0)
    val even = ListNode(0)
    var answerNode: ListNode? = answer
    var headNode = head
    var evenNode: ListNode? = even

    while (headNode != null) {
        answerNode?.next = headNode
        answerNode = answerNode?.next
        headNode = headNode.next

        evenNode?.next = headNode
        evenNode = evenNode?.next
        headNode = headNode?.next
    }

    evenNode?.next = null
    answerNode?.next = even.next

    return answer.next
}

// https://leetcode.com/problems/odd-even-linked-list/description/