package slidingwindow

fun main() {
    val (s1, k1) = "ABAB" to 2
    val (s2, k2) = "AABABBA" to 1

    println(characterReplacement(s1, k1))
    println(characterReplacement(s2, k2))
}

private fun characterReplacement(s: String, k: Int): Int {
    var answer = 0
    val count = IntArray(26)
    var maxCount = 0
    var l = 0

    for (r in s.indices) {
        val current = s[r] - 'A'

        count[current]++
        maxCount = maxOf(maxCount, count[current])

        if ((r - l + 1) - maxCount > k) {
            count[s[l] - 'A']--
            l++
        }

        answer = maxOf(answer, r - l + 1)
    }

    return answer
}

// https://leetcode.com/problems/longest-repeating-character-replacement/description/