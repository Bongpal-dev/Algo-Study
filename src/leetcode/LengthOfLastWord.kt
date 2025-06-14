package leetcode

fun main() {
    val s1 = "Hello World"
    val s2 = "   fly me   to   the moon  "
    val s3 = "luffy is still joyboy"

    println(lengthOfLastWord(s1))
    println(lengthOfLastWord(s2))
    println(lengthOfLastWord(s3))
}

private fun lengthOfLastWord(s: String): Int {
    var fin = false
    var count = 0

    for (i in s.length - 1 downTo 0) {
        when {
            fin && s[i] == ' ' -> break
            fin.not() && s[i] == ' ' -> continue
            else -> fin = true
        }
        count++
    }

    return count
}

// https://leetcode.com/problems/length-of-last-word/description/