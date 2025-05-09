package leetcode

fun main() {
    val (s1, numRows1) = "PAYPALISHIRING" to 3
    val (s2, numRows2) = "PAYPALISHIRING" to 4
    val (s3, numRows3) = "A" to 1
    val (s4, numRows4) = "AB" to 1

    println(convert(s1, numRows1))
    println(convert(s2, numRows2))
    println(convert(s3, numRows3))
    println(convert(s4, numRows4))
}

private fun convert(s: String, numRows: Int): String {
    if (numRows == 1) return s

    val rows = List(numRows) { mutableListOf<Char>() }
    var isDown = false
    var row = 0

    for (i in s.indices) {
        rows[row].add(s[i])

        if (row == 0 || row == numRows - 1) isDown = isDown.not()

        row += if (isDown) 1 else -1
    }

    return rows.joinToString("") { it.joinToString("") }
}

// https://leetcode.com/problems/zigzag-conversion/description/