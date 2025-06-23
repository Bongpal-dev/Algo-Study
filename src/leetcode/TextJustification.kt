package leetcode

fun main() {
    val (words1, maxWidth1) = arrayOf("This", "is", "an", "example", "of", "text", "justification.") to 16
    val (words2, maxWidth2) = arrayOf("What", "must", "be", "acknowledgment", "shall", "be") to 16
    val (words3, maxWidth3) = arrayOf(
        "Science",
        "is",
        "what",
        "we",
        "understand",
        "well",
        "enough",
        "to",
        "explain",
        "to",
        "a",
        "computer.",
        "Art",
        "is",
        "everything",
        "else",
        "we",
        "do"
    ) to 20

    println(fullJustify(words1, maxWidth1).joinToString("\n"))
    println()
    println(fullJustify(words2, maxWidth2).joinToString("\n"))
    println()
    println(fullJustify(words3, maxWidth3).joinToString("\n"))
}

private fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
    val answer = mutableListOf<String>()
    var length = 0
    var s = 0

    for (i in words.indices) {
        val currentLength = words[i].length

        if (length + currentLength + (i - s) > maxWidth) {
            answer += words.justify(s, i - 1, maxWidth, false)
            s = i
            length = 0
        }
        length += currentLength
    }

    answer += words.justify(s, words.size - 1, maxWidth, true)

    return answer
}

private fun Array<String>.justify(s: Int, e: Int, maxWidth: Int, isLastLine: Boolean): String {
    val t = this.slice(s..e)
    val len = t.sumOf { it.length }

    return buildString {
        if (isLastLine || t.size == 1) {
            append(t.joinToString(" "))
            while (length < maxWidth) append(" ")
            toString()
        } else {


            val space = maxWidth - len
            val b = space / (t.size - 1)
            var r = space % (t.size - 1)

            t.forEachIndexed { i, word ->
                append(word)

                if (i != t.lastIndex) {
                    repeat(b) { append(" ") }
                    if (r-- > 0) append(" ")
                }
            }
        }
    }
}

// https://leetcode.com/problems/text-justification/description/