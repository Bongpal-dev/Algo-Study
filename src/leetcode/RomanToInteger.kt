package leetcode

fun main() {
    val s1 = "III"
    val s2 = "LVIII"
    val s3 = "MCMXCIV"

    println(romanToInt(s1))
    println(romanToInt(s2))
    println(romanToInt(s3))
}


private val romanInteger = hashMapOf(
    'M' to 1000,
    'D' to 500,
    'C' to 100,
    'L' to 50,
    'X' to 10,
    'V' to 5,
    'I' to 1,
)

private fun romanToInt(s: String): Int {
    var answer = 0
    var prev = 0

    for (i in s.length - 1 downTo 0) {
        val curr = romanInteger[s[i]] ?: 0

        answer = if (curr < prev) answer - curr else answer + curr
        prev = curr
    }

    return answer
}

// https://leetcode.com/problems/roman-to-integer/description/