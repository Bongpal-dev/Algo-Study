package leetcode

fun main() {
    println(clearDigits("abc"))
    println(clearDigits("cb34"))
}

private fun clearDigits(s: String): String {
    var sb = StringBuilder()

    for (c in s) {
        if (c.isDigit()) {
            sb.deleteCharAt(sb.lastIndex)
        } else {
            sb.append(c)
        }
    }

    return sb.toString()
}

// https://leetcode.com/problems/clear-digits/description/