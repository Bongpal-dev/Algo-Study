package stack

import kotlin.math.absoluteValue

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
    private val q = IntArray(k) { -1 }
    private var f = 0
    private var r = -1
    private var l = 0

    fun enQueue(value: Int): Boolean {
        return if (isFull().not()) {
            r = (r + 1) % q.size
            q[r] = value
            l++
            true
        } else {
            false
        }
    }

    fun deQueue(): Boolean {
        return if (isEmpty().not()) {
            f = (f + 1) % q.size
            l--
            true
        } else {
            false
        }
    }

    fun Front(): Int {
        return if (isEmpty()) - 1 else q[f]
    }

    fun Rear(): Int {
        return if (isEmpty()) -1 else q[r]
    }

    fun isEmpty(): Boolean {
        return l == 0
    }

    fun isFull(): Boolean {
        return l == q.size
    }
}

// https://leetcode.com/problems/design-circular-queue/description/