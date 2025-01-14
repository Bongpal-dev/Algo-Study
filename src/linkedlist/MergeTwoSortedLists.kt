package linkedlist

fun main() {
    val (list11, list21) = ListNode(1).apply { add(2); add(4) } to ListNode(1).apply { add(3); add(4) }
    val (list12, list22) = null to null
    val (list13, list23) = null to ListNode(0)

    println(mergeTwoLists(list11, list21)?.joinToString())
    println(mergeTwoLists(list12, list22)?.joinToString())
    println(mergeTwoLists(list13, list23)?.joinToString())
}

private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    return when {
        list1 == null && list2 == null -> return null
        list1 == null -> return list2
        list2 == null -> return list1
        else -> mergeList(list1, list2)
    }
}

private fun mergeList(list1: ListNode, list2: ListNode): ListNode {
    var result = ListNode(0)
    var nodeR = result
    var node1: ListNode? = list1
    var node2: ListNode? = list2

    while (node1 != null || node2 != null) {
        if (node1 == null) {
            nodeR.next = node2
            break
        }

        if (node2 == null) {
            nodeR.next = node1
            break
        }

        if (node1.`val` <= node2.`val`) {
            nodeR.next = node1
            nodeR = nodeR.next!!
            node1 = node1.next
        } else {
            nodeR.next = node2
            nodeR = nodeR.next!!
            node2 = node2.next
        }
    }

    return result.next!!
}

// https://leetcode.com/problems/merge-two-sorted-lists/description/