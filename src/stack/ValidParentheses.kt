package stack

fun main() {
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("(]"))
    println(isValid("([])"))

}

private fun isValid(s: String): Boolean {
    val stack = mutableListOf<Char>()

    for (c in s) {
        val latest = stack.lastOrNull()

        if (latest.isMatch(c)) {
            stack.removeLast()
        } else {
            stack.add(c)
        }
    }

    return stack.isEmpty()
}

private fun Char?.isMatch(close: Char): Boolean {
    return when {
        this == '(' && close == ')' -> true
        this == '[' && close == ']' -> true
        this == '{' && close == '}' -> true
        else -> false
    }
}

// https://leetcode.com/problems/valid-parentheses/description/