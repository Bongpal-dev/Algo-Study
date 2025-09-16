package leetcode

fun main() {
    val n1 = 2
    val n2 = 3
    val n3 = 4

    println(baseNeg2(n1))
    println(baseNeg2(n2))
    println(baseNeg2(n3))
}

private fun baseNeg2(n: Int): String {
    if (n == 0) return "0"

    var r = n
    val sb = StringBuilder()

    while (r != 0) {
        val m = r % -2

        if (m < 0) {
            sb.insert(0, "1")
            r = (r / -2) + 1
        } else {
            sb.insert(0, m.toString())
            r /= -2
        }
    }

    return sb.toString()
}

// https://leetcode.com/problems/convert-to-base-2/description/