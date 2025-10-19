package leetcode

fun main() {
    val s1 = "5525"
    val (a1, b1) = 9 to 2
    val s2 = "74"
    val (a2, b2) = 5 to 1
    val s3 = "0011"
    val (a3, b3) = 4 to 2

    println(findLexSmallestString(s1, a1, b1))
    println(findLexSmallestString(s2, a2, b2))
    println(findLexSmallestString(s3, a3, b3))
}

private fun findLexSmallestString(s: String, a: Int, b: Int): String {
    val queue = mutableListOf<String>()
    val seen = HashSet<String>()
    var ans = s

    queue += s
    seen += s

    while (queue.isNotEmpty()) {
        val current = queue.removeFirst()

        ans = minOf(ans, current)
        current.addNum(a).let { if (seen.add(it)) queue += it }
        current.rotateStr(b).let { if (seen.add(it)) queue += it }
    }

    return ans
}

private fun String.rotateStr(b: Int): String {
    return this.substring(b) + this.substring(0, b)
}

private fun String.addNum(a: Int): String {
    val chars = this.toCharArray()

    for (i in 1..this.lastIndex step 2) {
        val add = (chars[i] - '0' + a) % 10

        chars[i] = ('0'.code + add).toChar()
    }

    return chars.joinToString("")
}

// https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/description/