package leetcode

fun main() {
    val (num11, num21) = "2" to "3"
    val (num12, num22) = "123" to "456"
    val (num13, num23) = "0" to "0"
    val (num14, num24) = "9" to "9"

    println(multiply(num11, num21))
    println(multiply(num12, num22))
    println(multiply(num13, num23))
    println(multiply(num14, num24))
}

private fun multiply(num1: String, num2: String): String {
    val arr = IntArray(num1.length + num2.length)

    for (i in num1.lastIndex downTo 0) {
        for (j in num2.lastIndex downTo 0) {
            val num = (num1[i].code - 48) * (num2[j].code - 48)
            val sum = num + arr[i + j + 1]

            arr[i + j + 1] = sum % 10
            arr[i + j] += sum / 10
        }
    }

    return arr.toNumString()
}

private fun IntArray.toNumString(): String {
    val sb = StringBuilder()

    for (c in this) {
        if (sb.isNotEmpty() || c != 0) {
            sb.append(c)
        }
    }

    return if (sb.isEmpty()) "0" else sb.toString()
}

// https://leetcode.com/problems/multiply-strings/description/