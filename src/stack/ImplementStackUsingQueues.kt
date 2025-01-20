package stack

fun main() {
    val stack = MyStack()

    println(stack.push(1))
    println(stack.push(2))
    println(stack.top())
    println(stack.pop())
    println(stack.empty())
}

private class MyStack() {
    private val mStack = mutableListOf<Int>()

    fun push(x: Int) {
        mStack.add(x)
    }

    fun pop(): Int {
        return mStack.removeLast()
    }

    fun top(): Int {
        return mStack.last()
    }

    fun empty(): Boolean {
        return mStack.isEmpty()
    }
}

// https://leetcode.com/problems/implement-stack-using-queues/description/