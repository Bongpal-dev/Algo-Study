package leetcode

fun main() {
    val s1 = "abab"
    val s2 = "abcd"
    val s3 = "aaaa"

    println(maxDistinct(s1))
    println(maxDistinct(s2))
    println(maxDistinct(s3))
}

private fun maxDistinct(s: String): Int {
    var ans = 0
    val exist = BooleanArray(26)

    for(c in s) {
        val i  = c.code - 'a'.code

        if(exist[i]) continue

        ans++
        exist[i] = true
    }

    return ans
}

// https://leetcode.com/problems/maximum-substrings-with-distinct-start/description/