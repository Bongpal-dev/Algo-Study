package leetcode

fun main() {
    val s1 = "3902"
    val s2 = "34789"

    println(hasSameDigits(s1))
    println(hasSameDigits(s2))
}

private fun hasSameDigits(s: String): Boolean {
    var l = s.map{it.digitToInt()}
    var prev = 0

    while (l.size > 2) {
        val r = mutableListOf<Int>()

        prev = l[0]

        for(i in 1 ..  l.lastIndex) {
            r += (prev + l[i]) % 10
            prev = l[i]
        }
        l = r
    }

    return l[0] == l[1]
}

// https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/description/