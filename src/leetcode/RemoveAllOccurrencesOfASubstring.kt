package leetcode

fun main() {
    val (s1, part1) = "daabcbaabcbc" to "abc"
    val (s2, part2) = "axxxxyyyyb" to "xy"

    println(removeOccurrences(s1, part1))
    println(removeOccurrences(s2, part2))
}

private fun removeOccurrences(s: String, part: String): String {
    val stack = StringBuilder()

    for (c in s) {
        stack.append(c)

        if (stack.length < part.length) continue

        if (stack.substring(stack.length - part.length) == part) {
            stack.deleteRange(stack.length - part.length, stack.length)
        }
    }

    return stack.toString()
}

// https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description