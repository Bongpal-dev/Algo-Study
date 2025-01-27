package deque

import linkedlist.ListNode

fun main() {
    val case1: Array<ListNode?> = arrayOf(
        ListNode(1).apply { add(4); add(5) },
        ListNode(1).apply { add(3); add(4) },
        ListNode(2).apply { add(6) },
    )

    println(mergeKLists(case1)?.joinToString())

}

private fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val answer = ListNode(0)
    var answerNode = answer

    while (true) {
        if (lists.all { it == null }) break

        var minV = Int.MAX_VALUE
        var minI = -1

        for (i in lists.indices) {
            if (lists[i] != null && lists[i]!!.`val` < minV) {
                minV = lists[i]!!.`val`
                minI = i
            }
        }

        answerNode.next = lists[minI]
        answerNode = answerNode.next!!
        lists[minI] = lists[minI]?.next
    }

    return answer.next
}

// https://leetcode.com/problems/merge-k-sorted-lists/description/