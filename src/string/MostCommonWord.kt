package string

private fun main() {
    val case1: Pair<String, Array<String>> = "Bob hit a ball, the hit BALL flew far after it was hit." to arrayOf("hit")
    val case2: Pair<String, Array<String>> = "a." to arrayOf()

    println(mostCommonWord(case1.first, case1.second))
    println(mostCommonWord(case2.first, case2.second))
}

private fun mostCommonWord(paragraph: String, banned: Array<String>): String {
    val buffer = StringBuilder()
    val result = HashMap<String, Int>()
    var maxCount = 0
    var maxValue = ""

    for (c in paragraph) {
        if (banned.contains(buffer.toString())) {
            buffer.clear()
            continue
        }

        if (c.isLetterOrDigit()) {
            buffer.append(c.lowercase())
            continue
        }

        if (buffer.isNotBlank()) {
            val v = buffer.toString()
            val c = result.getOrDefault(v, 0) + 1

            result[v] = c

            if (c > maxCount) {
                maxCount = c
                maxValue = v
            }
            buffer.clear()
        }
    }

    if (buffer.isNotBlank()) {
        val v = buffer.toString()
        val c = result.getOrDefault(v, 0) + 1

        result[v] = c

        if (c > maxCount) {
            maxValue = v
        }
    }

    return maxValue
}

// https://leetcode.com/problems/most-common-word/description/