package leetcode

fun main() {
    val (s1, words1) = "barfoothefoobarman" to arrayOf("foo", "bar")
    val (s2, words2) = "wordgoodgoodgoodbestword" to arrayOf("word", "good", "best", "word")
    val (s3, words3) = "barfoofoobarthefoobarman" to arrayOf("bar", "foo", "the")

    println(findSubstring(s1, words1))
    println(findSubstring(s2, words2))
    println(findSubstring(s3, words3))
}

private fun findSubstring(s: String, words: Array<String>): List<Int> {
    val answer = mutableListOf<Int>()
    val wordLength = words[0].length
    val allSize = wordLength * words.size
    val w = words.groupingBy { it }.eachCount()

    for (i in 0..s.length - allSize) {
        val count = mutableMapOf<String, Int>()
        var j = 0

        while (j < words.size) {
            val word = s.substring(i + j * wordLength, i + (j + 1) * wordLength)

            if(word !in w) break

            count[word] = count.getOrDefault(word, 0) + 1

            if(count[word]!! > w[word]!!) break

            j++
        }

        if(j == words.size) answer += i
    }

    return answer
}

// https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/