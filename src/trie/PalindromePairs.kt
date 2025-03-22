package trie

fun main() {
    val words1 = arrayOf("abcd", "dcba", "lls", "s", "sssll")
    val words2 = arrayOf("bat", "tab", "cat")
    val words3 = arrayOf("a", "")

    println(palindromePairs(words1))
    println(palindromePairs(words2))
    println(palindromePairs(words3))
}

private fun palindromePairs(words: Array<String>): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val trie = Node()

    words.forEachIndexed { i, word ->
        var current = trie

        for (j in word.length - 1 downTo 0) {
            if (word.isPalindrome(0, j)) {
                current.palindromeSuffixIndices.add(i)
            }
            current = current.children.getOrPut(word[j]) { Node() }
        }
        current.index = i
        current.palindromeSuffixIndices.add(i)
    }

    words.forEachIndexed { i, word ->
        var current = trie

        for (j in word.indices) {
            if (current.index >= 0 && current.index != i) {
                if (word.isPalindrome(j, word.length - 1)) {
                    result.add(listOf(i, current.index))
                }
            }
            current = current.children[word[j]] ?: return@forEachIndexed
        }

        for (j in current.palindromeSuffixIndices) {
            if (j != i) {
                result.add(listOf(i, j))
            }
        }
    }


    return result
}

private fun String.isPalindrome(start: Int, end: Int): Boolean {
    var s = start
    var e = end

    while (s < e) {
        if (this[s] != this[e]) return false

        s++
        e--
    }
    return true
}

private class Node {
    val children: MutableMap<Char, Node> = hashMapOf()
    var index: Int = -1
    val palindromeSuffixIndices: MutableList<Int> = mutableListOf()
}

// https://leetcode.com/problems/palindrome-pairs/description/