package leetcode

fun main() {
    val (text1, brokenLetters1) = "hello world" to "ad"
    val (text2, brokenLetters2) = "leet code" to "lt"
    val (text3, brokenLetters3) = "leet code" to "e"

    println(canBeTypedWords(text1, brokenLetters1))
    println(canBeTypedWords(text2, brokenLetters2))
    println(canBeTypedWords(text3, brokenLetters3))
}

private fun canBeTypedWords(text: String, brokenLetters: String): Int {
    var ans = 0
    val b = hashSetOf<Char>()

    brokenLetters.forEach { b += it }

    var skip = false

    for (c in text) {
        when (c) {
            ' ' -> {
                if (skip.not()) ans++

                skip = false;
            }

            in b -> skip = true
        }

    }

    if (skip.not()) ans++

    return ans
}

// https://leetcode.com/problems/maximum-number-of-words-you-can-type/description