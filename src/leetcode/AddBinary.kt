package leetcode

fun main() {
    val (a1, b1) = "11" to "1"
    val (a2, b2) = "1010" to "1011"

    println(addBinary(a1, b1))
    println(addBinary(a2, b2))
}

private fun addBinary(a: String, b: String): String {
    val sb = StringBuilder()
    var i = a.length - 1
    var j = b.length - 1
    var c = 0

    while (i >= 0 || j >= 0) {
        val n = if (i >= 0) a[i--] - '0' else 0
        val m = if (j >= 0) b[j--] - '0' else 0
        val sum = n + m + c

        sb.append(sum % 2)
        c = sum / 2
    }

    if (c == 1) sb.append(c)

    return sb.reverse().toString()
}

// https://leetcode.com/problems/add-binary/description/