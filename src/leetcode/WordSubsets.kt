package leetcode

fun main() {
    val (words11, words12) = arrayOf("amazon", "apple", "facebook", "google", "leetcode") to arrayOf("e", "o")
    val (words21, words22) = arrayOf("amazon", "apple", "facebook", "google", "leetcode") to arrayOf("l", "e")
    val (words31, words32) = arrayOf("amazon", "apple", "facebook", "google", "leetcode") to arrayOf("lo", "eo")
    val (words41, words42) = arrayOf("abbac", "aabac", "bbacb", "aacac", "bcabb") to arrayOf("c", "bc", "aa")

    println(wordSubsets(words11, words12))
    println(wordSubsets(words21, words22))
    println(wordSubsets(words31, words32))
    println(wordSubsets(words41, words42))
}

private fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
    val count = hashMapOf<Char, Int>()

    words2.forEach { word ->
        word
            .groupingBy { it }
            .eachCount()
            .forEach { (k, v) ->
                val c = count.getOrDefault(k, 0)

                count[k] = maxOf(c, v)
            }
    }

    return words1.mapNotNull { word ->
        val c = word
            .groupingBy { it }
            .eachCount()

        if (isSubset(c, count)) word else null
    }
}

private fun isSubset(set1: Map<Char, Int>, set2: Map<Char, Int>): Boolean {
    var a = 0

    for ((k,v) in set1) {
        set2[k]?.let {
            if (v >= it) a++
        }
    }

    return set2.size == a
}

// https://leetcode.com/problems/word-subsets/description/?envType=daily-question&envId=2025-01-10