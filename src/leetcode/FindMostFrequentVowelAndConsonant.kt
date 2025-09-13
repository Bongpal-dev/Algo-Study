package leetcode

fun main() {
    val s1 = "successes"
    val s2 = "aeiaeia"

    println(maxFreqSum(s1))
    println(maxFreqSum(s2))
}

private fun maxFreqSum(s: String): Int {
    val vows = IntArray(5)
    val chars = IntArray(26)

    for (c in s) {
        when (c) {
            'a' -> vows[0]++
            'e' -> vows[1]++
            'i' -> vows[2]++
            'o' -> vows[3]++
            'u' -> vows[4]++
            else -> chars[c - 'a']++
        }
    }

    return vows.max() + chars.max()
}

// https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/description