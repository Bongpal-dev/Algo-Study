package leetcode

fun main() {
    val columnTitle1 = "A"
    val columnTitle2 = "AB"
    val columnTitle3 = "ZY"

    println(titleToNumber(columnTitle1))
    println(titleToNumber(columnTitle2))
    println(titleToNumber(columnTitle3))
}

private fun titleToNumber(columnTitle: String): Int {
    var answer = 0

    for(c in columnTitle) {
         val cCode = c.code % 'A'.code

        answer *= 26
        answer += cCode + 1
    }

    return answer
}

// https://leetcode.com/problems/excel-sheet-column-number/description/