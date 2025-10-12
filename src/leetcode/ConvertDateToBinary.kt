package leetcode

fun main() {
    val date1 = "2080-02-29"
    val date2 = "1900-01-01"

    println(convertDateToBinary(date1))
    println(convertDateToBinary(date2))
}

private fun convertDateToBinary(date: String) = date.split("-").joinToString("-") { it.toInt().toString(2) }

// https://leetcode.com/problems/convert-date-to-binary/description/