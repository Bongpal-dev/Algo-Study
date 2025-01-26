package deque

import kotlin.math.absoluteValue

fun main() {
    val myCircularDeque = MyCircularDeque(3)

    println(myCircularDeque.insertLast(1))  // return True
    println(myCircularDeque.insertLast(2))  // return True
    println(myCircularDeque.insertFront(3)) // return True
    println(myCircularDeque.insertFront(4)) // return False, the queue is full.
    println(myCircularDeque.getRear())      // return 2
    println(myCircularDeque.isFull())       // return True
    println(myCircularDeque.deleteLast())   // return True
    println(myCircularDeque.insertFront(4)) // return True
    println(myCircularDeque.getFront())     // return 4
}

private class MyCircularDeque(k: Int) {
    private val mDeque = IntArray(k) { -1 }
    private var f = 1
    private var l = 0
    private var size = 0

    fun insertFront(value: Int): Boolean {
        return if (this.isFull()) {
            false
        } else {
            f = (f - 1 + mDeque.size) % mDeque.size
            mDeque[f] = value
            size++
            true
        }
    }

    fun insertLast(value: Int): Boolean {
        return if (this.isFull()) {
            false
        } else {
            l = (l + 1) % mDeque.size
            mDeque[l] = value
            size++
            true
        }
    }

    fun deleteFront(): Boolean {
        return if (this.isEmpty()) {
            false
        } else {
            mDeque[f] = -1
            size--
            f = (f + 1) % mDeque.size
            true
        }
    }

    fun deleteLast(): Boolean {
        return if (this.isEmpty()) {
            false
        } else {
            mDeque[l] = -1
            size--
            l = (l - 1 + mDeque.size) % mDeque.size
            true
        }
    }

    fun getFront(): Int {
        return if (isEmpty()) -1 else mDeque[f]
    }

    fun getRear(): Int {
        return if (isEmpty()) -1 else mDeque[l]
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun isFull(): Boolean {
        return size == mDeque.size
    }
}

// https://leetcode.com/problems/design-circular-deque/description/