package linkedlist

fun main() {
    val case1 = ListNode(1).apply { add(2); add(2); add(1) }
    val case2 = ListNode(1).apply { add(2) }
    val case3 = ListNode(1).apply { add(0); add(1) }

    println(isPalindrome(case1))
    println(isPalindrome(case2))
    println(isPalindrome(case3))
}

private fun isPalindrome(head: ListNode?): Boolean {
    val last = head?.lastIndex ?: 0
    var node = head
    val stack = mutableListOf<Int>()

    if (last < 1) return true

    for (i in 0..last) {
        val v = node?.`val` ?: 0

        node = node?.next

        if (last % 2 == 0 && i == last / 2) continue

        if (i <= last / 2) {
            stack.add(v)
        } else {
            if (stack.last() == v) stack.removeLast()
        }
    }

    return stack.isEmpty()
}

private val ListNode.lastIndex
    get() = run {
        var node = this
        var r = 0

        while (node.next != null) {
            r++
            node = node.next!!
        }
        r
    }

// https://leetcode.com/problems/palindrome-linked-list/description/