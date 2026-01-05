package leetcode

fun main() {
    val (s1, k1) = "abcd" to 2
    val (s2, k2) = "xyz" to 3
    val (s3, k3) = "hey" to 1

    println(reversePrefix(s1, k1))
    println(reversePrefix(s2, k2))
    println(reversePrefix(s3, k3))
}

private fun reversePrefix(s: String, k: Int): String {
    val ans = StringBuilder()
    val idx = k - 1

    for (i in s.indices) {
        ans.append(if (i <= idx) s[idx - i] else s[i])
    }

    return ans.toString()
}

// https://leetcode.com/problems/reverse-string-prefix/description/