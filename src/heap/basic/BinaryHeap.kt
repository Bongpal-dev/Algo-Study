package heap.basic

class BinaryHeap {
    private val elements = mutableListOf<Int?>(null)

    fun add(n: Int) {
        elements.add(n)
        percolateUp()
    }

    fun removeFirst(): Int? {
        val result = elements[1]

        elements[1] = elements.removeLast()
        percolateDown()

        return result
    }

    private fun percolateUp() {
        var current = elements.lastIndex
        var parent = current / 2

        while (parent > 0) {
            if (elements[current]!! < elements[parent]!!) {
                elements[current] = elements[parent].also { elements[parent] = elements[current] }
            }

            current = parent
            parent = current / 2
        }
    }

    private fun percolateDown() {
        var current = 1

        while (true) {
            val left = current * 2
            val right = current * 2 + 1
            var smallest = current

            elements.getOrNull(left)?.let { lv ->
                if (left < elements.size && lv < elements[smallest]!!) {
                    smallest = left
                }
            }

            elements.getOrNull(right)?.let { rv ->
                if (right < elements.size && rv < elements[smallest]!!) {
                    smallest = right
                }
            }

            if (smallest == current) {
                break
            }

            elements[current] = elements[smallest].also { elements[smallest] = elements[current] }
            current = smallest
        }
    }

    override fun toString(): String {
        return elements.toString()
    }
}