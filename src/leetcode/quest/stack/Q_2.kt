package leetcode.quest.stack

fun main() {
    val tokens1 = arrayOf("2", "1", "+", "3", "*")
    val tokens2 = arrayOf("4", "13", "5", "/", "+")
    val tokens3 = arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")

    println(evalRPN(tokens1))
    println(evalRPN(tokens2))
    println(evalRPN(tokens3))
}

private fun evalRPN(tokens: Array<String>): Int {
    val op = hashSetOf("+", "-", "*", "/")
    val stack = mutableListOf<Int>()

    for (t in tokens) {
        if (t in op) {
            val b = stack.removeLast()
            val a = stack.removeLast()

            stack += op(a, b, t)
        } else {
            stack += t.toInt()
        }
    }

    return stack.last()
}

private fun op(a: Int, b: Int, op: String): Int {
    return when (op) {
        "+" -> a + b
        "-" -> a - b
        "*" -> a * b
        "/" -> a / b
        else -> 0
    }
}

// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/