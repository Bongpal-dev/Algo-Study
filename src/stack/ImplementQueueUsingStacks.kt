package stack

fun main() {
    val myQueue = MyQueue()

    println(myQueue.push(1))
    println(myQueue.push(2))
    println(myQueue.peek())
    println(myQueue.pop())
    println(myQueue.empty())
}

private class MyQueue() {
    val queue = mutableListOf<Int>()

    fun push(x: Int) {
        queue.add(x)
    }

    fun pop(): Int {
        return queue.removeFirst()
    }

    fun peek(): Int {
        return queue.first()
    }

    fun empty(): Boolean {
        return queue.size == 0
    }
}

// https://leetcode.com/problems/implement-queue-using-stacks/description/