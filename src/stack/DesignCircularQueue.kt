package stack

fun main() {
    val myCircularQueue = MyCircularQueue(3)

    println(myCircularQueue.enQueue(1)) // return True
    println(myCircularQueue.enQueue(2)) // return True
    println(myCircularQueue.enQueue(3)) // return True
    println(myCircularQueue.enQueue(4)) // return False
    println(myCircularQueue.Rear())     // return 3
    println(myCircularQueue.isFull())   // return True
    println(myCircularQueue.deQueue())  // return True
    println(myCircularQueue.enQueue(4)) // return True
    println(myCircularQueue.Rear())     // return 4
}

private class MyCircularQueue(k: Int) {
    private val mQueue = mutableListOf<Int>()
    private val size = k

    fun enQueue(value: Int): Boolean {
        return if (mQueue.size < size) {
            mQueue.add(value)
            true
        } else {
            false
        }
    }

    fun deQueue(): Boolean {
        return mQueue.removeFirstOrNull() != null
    }

    fun Front(): Int {
        return mQueue.firstOrNull() ?: -1
    }

    fun Rear(): Int {
        return mQueue.lastOrNull() ?: -1
    }

    fun isEmpty(): Boolean {
        return mQueue.isEmpty()
    }

    fun isFull(): Boolean {
        return mQueue.size == size
    }
}

// https://leetcode.com/problems/design-circular-queue/description/