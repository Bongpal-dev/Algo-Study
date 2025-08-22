package leetcode

fun main() {
    val (num11, num21) = "11" to "123"
    val (num12, num22) = "456" to "77"
    val (num13, num23) = "0" to "0"
    val (num14, num24) = "9" to "99"

    println(addStrings(num11, num21))
    println(addStrings(num12, num22))
    println(addStrings(num13, num23))
    println(addStrings(num14, num24))
}

private fun addStrings(num1: String, num2: String): String {
    val sb = StringBuilder()
    var i = num1.lastIndex
    var j = num2.lastIndex
    var carry = 0

    while (i >= 0 || j >= 0 || carry > 0) {
        val n1 = if (i >= 0) num1[i] - '0' else 0
        val n2 = if (j >= 0) num2[j] - '0' else 0
        val sum = n1 + n2 + carry

        sb.insert(0, '0' + (sum % 10))
        carry = sum / 10

        i--
        j--
    }

    return sb.toString()
}

// https://leetcode.com/problems/add-strings/description/