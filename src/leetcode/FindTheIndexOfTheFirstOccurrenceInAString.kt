package leetcode

fun main() {
    val (haystack1, needle1) = "sadbutsad" to "sad"
    val (haystack2, needle2) = "leetcode" to "leeto"
    val (haystack3, needle3) = "mississippi" to "issip"
    val (haystack4, needle4) = "mississippi" to "issipi"

//    println(strStr(haystack1, needle1))
//    println(strStr(haystack2, needle2))
//    println(strStr(haystack3, needle3))
    println(strStr(haystack4, needle4))
}

private fun strStr(haystack: String, needle: String): Int {
    if (haystack.length < needle.length) return -1

    if (haystack == needle) return 0

    for (i in haystack.indices) {
        if(haystack[i] != needle[0]) continue

        for(j in needle.indices) {
            if((i+j) !in haystack.indices || haystack[i+j] != needle[j]) break

            if(j == needle.length-1 && haystack[i+j] == needle[j]) return i
        }
    }

    return -1
}

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/