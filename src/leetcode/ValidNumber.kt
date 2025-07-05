package leetcode

fun main() {
    val s1 = "0"
    val s2 = "e"
    val s3 = "--6"
    val s4 = "+6e-1"
    val s5 = "9554e53"
    val s6 = "-6.5.3"
    val s7 = "+.8"
    val s8 = "46.e3"
    val s9 = ".e1"

//    println(isNumber(s1))
//    println(isNumber(s2))
//    println(isNumber(s3))
//    println(isNumber(s4))
//    println(isNumber(s5))
//    println(isNumber(s6))
//    println(isNumber(s7))
//    println(isNumber(s8))
    println(isNumber(s9))
}

private fun isNumber(s: String): Boolean {
    val str = s.trim()

    if (str.isEmpty()) return false

    var seenDot = false
    var seenE = false
    var seenDigit = false

    for (i in str.indices) {
        val c = str[i]

        when {
            c.isDigit() -> {
                seenDigit = true
            }

            c.isSign() -> {
                if (i > 0 && str[i - 1].isExponent().not()) return false
                if (i == str.lastIndex) return false
            }

            c.isDot() -> {
                if (seenDot || seenE) return false

                val prevDigit = i > 0 && str[i - 1].isDigit()
                val nextDigit = i < str.lastIndex && str[i + 1].isDigit()

                if ((prevDigit || nextDigit).not()) return false

                seenDot = true
            }

            c.isExponent() -> {
                if (seenE || seenDigit.not()) return false
                if (i == str.lastIndex) return false

                seenE = true
                seenDigit = false
            }

            else -> return false
        }
    }

    return seenDigit
}

private fun Char.isDot() = this == '.'
private fun Char.isSign() = this == '+' || this == '-'
private fun Char.isExponent() = this == 'e' || this == 'E'

// https://leetcode.com/problems/valid-number/description/