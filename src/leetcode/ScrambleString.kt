package leetcode

fun main() {
    val (s11, s21) = "great" to "rgeat"
    val (s12, s22) = "abcde" to "caebd"
    val (s13, s23) = "a" to "a"
    val (s14, s24) = "ab" to "dg"

    println(isScramble(s11, s21))
    println(isScramble(s12, s22))
    println(isScramble(s13, s23))
    println(isScramble(s14, s24))
}

private fun isScramble(s1: String, s2: String): Boolean {
    if (s1.length != s2.length) return false

    val memo = hashMapOf<String, Boolean>()

    return find(s1, s2, memo)
}

private fun find(a: String, b: String, memo: HashMap<String, Boolean>): Boolean {
    val key = "$a-$b"

    memo[key]?.let { return it }

    if (a == b) return true.also { memo[key] = it }
    if (isSameSet(a, b).not()) return false.also { memo[key] = it }

    val n = a.length

    for (i in 1 until n) {
        if (
            find(a.substring(0, i), b.substring(0, i), memo) &&
            find(a.substring(i), b.substring(i), memo) ||
            find(a.substring(0, i), b.substring(n - i), memo) &&
            find(a.substring(i), b.substring(0, n - i), memo)
        ) {
            return true.also { memo[key] = it }
        }
    }

    return false.also { memo[key] = it }
}

private fun isSameSet(a: String, b: String): Boolean {
    val arr = IntArray(26)

    for (i in a.indices) {
        arr[a[i] - 'a']++
        arr[b[i] - 'a']--
    }

    return arr.all { it == 0 }
}

// https://leetcode.com/problems/scramble-string/description/