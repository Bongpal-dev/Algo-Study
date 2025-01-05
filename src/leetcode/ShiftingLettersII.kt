package leetcode

private fun main() {
    val (s1, shifts1) = "abc" to arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 2, 1), intArrayOf(0, 2, 1))
    val (s2, shifts2) = "dztz" to arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 1, 1))
    val (s3, shifts3) = "iaozjb" to arrayOf(
        intArrayOf(0, 4, 0),
        intArrayOf(0, 2, 1),
        intArrayOf(1, 3, 1),
        intArrayOf(0, 4, 1),
        intArrayOf(4, 4, 1),
        intArrayOf(2, 3, 0),
        intArrayOf(5, 5, 0),
        intArrayOf(3, 3, 0),
        intArrayOf(2, 3, 0),
        intArrayOf(5, 5, 1),
        intArrayOf(5, 5, 1),
        intArrayOf(5, 5, 0),
    )

    println(shiftingLetters(s1, shifts1))
    println(shiftingLetters(s2, shifts2))
    println(shiftingLetters(s3, shifts3))
}

private fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
    val sb = StringBuilder().apply { append(s) }

    for (sh in shifts) {
        val range = sh[0]..sh[1]

        sb.shiftsChar(range, sh[2])
    }
    return sb.toString()
}

private fun StringBuilder.shiftsChar(range: IntRange, direction: Int) {
    for (i in range) {
        if (direction == 0) {
            this[i] = (this[i].code - 1).toLowerChar()
        } else {
            this[i] = (this[i].code + 1).toLowerChar()
        }
    }
}

private fun Int.toLowerChar(): Char {
    if (this < 97) {
        return (123 - (97 - this)).toChar()
    }

    if (this > 122) {
        return (96 + (this % 122)).toChar()
    }

    return this.toChar()
}

// https://leetcode.com/problems/shifting-letters-ii/description/?envType=daily-question&envId=2025-01-05