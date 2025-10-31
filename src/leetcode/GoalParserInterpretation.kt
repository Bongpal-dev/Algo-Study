package leetcode

fun main() {
    val command1 = "G()(al)"
    val command2 = "G()()()()(al)"
    val command3 = "(al)G(al)()()G"

    println(interpret(command1))
    println(interpret(command2))
    println(interpret(command3))
}

private fun interpret(command: String): String {
    val sb = StringBuilder()
    var prev = ' '

    for (c in command) {
        when (c) {
            'G' -> sb.append(c)
            ')' -> sb.append(if (prev == '(') 'o' else "al")
        }
        prev = c
    }

    return sb.toString()
}

// https://leetcode.com/problems/goal-parser-interpretation/description/