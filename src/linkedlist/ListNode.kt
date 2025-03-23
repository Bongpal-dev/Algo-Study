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

    fun joinToString(
        separator: CharSequence = ", ",
        prefix: CharSequence = "",
        postfix: CharSequence = "",
        limit: Int = -1,
        truncated: CharSequence = "...",
        transform: ((Int) -> CharSequence)? = null
    ): String {
        var node: ListNode? = this
        val result = mutableListOf<Int>()

        while (node != null) {
            result += node.`val`
            node = node.next
        }

        return "[" + result.joinToString(
            separator = separator,
            prefix = prefix,
            postfix = postfix,
            limit = limit,
            truncated = truncated,
            transform = transform
        ) + "]"
    }
}

fun List<Int>.toListNode(): ListNode? {
    if (this.isEmpty()) null

    val root = ListNode(0)
    var current: ListNode? = root

    this.forEach {
        current?.next = ListNode(it)
        current = current?.next
    }

    return root.next
}