package leetcode

fun main() {
    val strs1 = arrayOf("flower", "flow", "flight")
    val strs2 = arrayOf("dog", "racecar", "car")

    println(longestCommonPrefix(strs1))
    println(longestCommonPrefix(strs2))
}

private fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    if (strs.size == 1) return strs[0]

    var i = 0

    while (true) {
        if (i >= strs[0].length) break

        val c = strs[0][i]

        for (s in strs) {
            if (i >= s.length || s[i] != c) return strs[0].substring(0, i)
        }

        i++
    }

    return strs[0].substring(0, i)
}

// https://leetcode.com/problems/longest-common-prefix/description/