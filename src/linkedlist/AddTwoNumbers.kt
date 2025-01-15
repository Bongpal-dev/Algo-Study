package linkedlist

fun main() {
    val (l11, l21) = ListNode(2).apply { add(4); add(3); } to ListNode(5).apply { add(6); add(4) }
    val (l12, l22) = ListNode(0) to ListNode(0)
    val (l13, l23) =
        ListNode(9).apply { add(9); add(9); add(9); add(9); add(9); add(9); } to
                ListNode(9).apply { add(9); add(9); add(9) }

    println(addTwoNumbers(l11, l21)?.joinToString())
    println(addTwoNumbers(l12, l22)?.joinToString())
    println(addTwoNumbers(l13, l23)?.joinToString())
}

private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val answer = ListNode(0)
    var nodeAnswer: ListNode? = answer
    var node1 = l1
    var node2 = l2
    var overTen = false

    while (node1 != null || node2 != null) {
        val sum = when {
            node1 == null -> node2?.`val` ?: 0
            node2 == null -> node1.`val`
            else -> node1.`val` + node2.`val`
        } + if (overTen) 1 else 0

        overTen = sum > 9

        nodeAnswer?.next = ListNode(sum % 10)
        nodeAnswer = nodeAnswer?.next
        node1 = node1?.next
        node2 = node2?.next
    }

    if (overTen) nodeAnswer?.next = ListNode(1)

    return answer.next
}

// https://leetcode.com/problems/add-two-numbers/description/