package leetcode

import linkedlist.ListNode
import linkedlist.toListNode

fun main() {
    val head1 = listOf(18, 6, 10, 3).toListNode()
    val head2 = listOf(7).toListNode()

    println(insertGreatestCommonDivisors(head1)?.joinToString())
    println(insertGreatestCommonDivisors(head2)?.joinToString())
}

private fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
    if(head == null) return null

    var node: ListNode = head

    while(node.next != null) {
        val gcd = getGcd(node.`val`, node.next!!.`val`)
        val new = ListNode(gcd)

        new.next = node.next
        node.next = new

        node = new.next!!
    }

    return head
}

private fun getGcd(a: Int, b: Int): Int = if (b == 0) a else getGcd(b, a % b)

// https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/description/