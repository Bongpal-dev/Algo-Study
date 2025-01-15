package linkedlist

fun main() {
    val case1 = ListNode(1).apply { add(2); add(3); add(4) }
    val case2 = null
    val case3 = ListNode(1)
    val case4 = ListNode(1).apply { add(2); add(3) }

    println(swapPairs(case1)?.joinToString())
    println(swapPairs(case2)?.joinToString())
    println(swapPairs(case3)?.joinToString())
    println(swapPairs(case4)?.joinToString())
}

private fun swapPairs(head: ListNode?): ListNode? {
    if (head == null) return null
    if (head.next == null) return head

    val answer = ListNode(0)
    var nodeAnswer: ListNode? = answer
    var node = head
    var next: ListNode? = null

    while (node != null) {
        next = node.next?.next
        nodeAnswer?.next = node.next ?: break
        node.next = next
        nodeAnswer?.next?.next = node
        nodeAnswer = nodeAnswer?.next?.next
        node = next
    }

    return answer.next
}

// https://leetcode.com/problems/swap-nodes-in-pairs/description/