package leetcode

import linkedlist.ListNode
import linkedlist.toListNode

fun main() {
    val (nums1, head1) = intArrayOf(1, 2, 3) to listOf(1, 2, 3, 4, 5).toListNode()
    val (nums2, head2) = intArrayOf(1) to listOf(1, 2, 1, 2, 1, 2).toListNode()
    val (nums3, head3) = intArrayOf(5) to listOf(1, 2, 3, 4).toListNode()

    println(modifiedList(nums1, head1)?.joinToString())
    println(modifiedList(nums2, head2)?.joinToString())
    println(modifiedList(nums3, head3)?.joinToString())
}

private fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
    val n = nums.toHashSet()
    val ans = ListNode(0).apply { next = head }
    var prev = ans
    var current: ListNode? = head

    while (current != null) {
        if(current.`val` in n) {
            prev.next = current.next
        } else {
            prev = current
        }
        current = current.next
    }

    return ans.next
}

// https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/