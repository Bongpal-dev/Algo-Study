package leetcode

fun main() {
    val columnNumber1 = 1
    val columnNumber2 = 28
    val columnNumber3 = 701

    println(convertToTitle(columnNumber1))
    println(convertToTitle(columnNumber2))
    println(convertToTitle(columnNumber3))
}

private fun convertToTitle(columnNumber: Int): String {
    val sb = StringBuilder()
    var r  = columnNumber

    while(r > 0) {
        val n = --r % 26 + 65

        r /= 26
        sb.append(n.toChar())
    }

    return sb.reverse().toString()
}

// https://leetcode.com/problems/excel-sheet-column-title/description/