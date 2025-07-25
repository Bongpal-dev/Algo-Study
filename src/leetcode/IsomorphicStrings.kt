package leetcode

fun main() {
    val (s1, t1) = "egg" to "add"
    val (s2, t2) = "foo" to "bar"
    val (s3, t3) = "paper" to "title"
    val (s4, t4) = "badc" to "baba"

    println(isIsomorphic(s1, t1))
    println(isIsomorphic(s2, t2))
    println(isIsomorphic(s3, t3))
    println(isIsomorphic(s4, t4))
}

private fun isIsomorphic(s: String, t: String): Boolean {
    return check(s, t) && check(t, s)
}

private fun check(s: String, t: String): Boolean {
    val map = hashMapOf<Char, Char>()

    for (i in s.indices) {
        if (map.containsKey(s[i])) {
            if (map[s[i]] != t[i]) return false
        } else {
            map[s[i]] = t[i]
        }
    }

    return true
}

// https://leetcode.com/problems/isomorphic-strings/description/