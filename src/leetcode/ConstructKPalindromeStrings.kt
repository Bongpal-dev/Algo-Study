package leetcode

fun main() {
    val (s1, k1) = "annabelle" to 2
    val (s2, k2) = "leetcode" to 3
    val (s3, k3) = "true" to 4
    val (s4, k4) = "qlkzenwmmnpkopu" to 15
    val (s5, k5) = "cr" to 7

    println(canConstruct(s1, k1))
    println(canConstruct(s2, k2))
    println(canConstruct(s3, k3))
    println(canConstruct(s4, k4))
    println(canConstruct(s5, k5))
}

private fun canConstruct(s: String, k: Int): Boolean {
    if (s.length == k) return true
    if (s.length < k) return false

    val count = IntArray(26)

    s.forEach { count[it - 'a']++ }

    return count.count { it % 2 != 0 } <= k
}

// https://leetcode.com/problems/construct-k-palindrome-strings/description/

/*
private fun canConstruct(s: String, k: Int): Boolean {

    if (s.length == k) return true

    val count = hashMapOf<Char, Int>()

    s.forEach {
        count[it] = count.getOrDefault(it, 0) + 1
    }

    count.values
        .count { it % 2 != 0 }
        .let { return it == 1 || it <= k }
}
 */