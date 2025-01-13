package linkedlist

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun add(value: Int) {
        var node = this

        while (node.next != null) {
            node = node.next!!
        }
        node.next = ListNode(value)
    }
}