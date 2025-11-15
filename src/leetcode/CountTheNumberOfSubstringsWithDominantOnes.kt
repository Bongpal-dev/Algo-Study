package leetcode

fun main() {
    val s1 = "00011"
    val s2 = "101101"
    val s3 = "010"

    println(numberOfSubstrings(s1))
    println(numberOfSubstrings(s2))
    println(numberOfSubstrings(s3))
}

private fun numberOfSubstrings(s: String): Int {
    var ans = 0
    var z = 0

    while (z * z + z <= s.length) {
        ans += s.count(z)
        z++
    }

    return ans
}

private fun String.count(z: Int): Int {
    var result = 0
    var (zero, one) = 0 to 0
    var l = 0
    var prev = -1

    for (r in 0..this.lastIndex) {
        if (this[r] == '0') zero++ else one++

        while (l < r) {
            when {
                this[l] == '0' && z < zero -> {
                    zero--
                    prev = l
                }

                this[l] == '1' && one - 1 >= z * z -> {
                    one--
                }

                else -> break
            }
            l++
        }

        if (zero == z && one >= z * z) result += l - prev
    }

    return result
}

// https://leetcode.com/problems/count-the-number-of-substrings-with-dominant-ones/description/