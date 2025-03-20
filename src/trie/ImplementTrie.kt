package trie

fun main() {
    val trie = Trie()
    println(trie.insert("apple"))
    println(trie.search("apple"))
    println(trie.search("app"))
    println(trie.startsWith("app"))
    println(trie.insert("app"))
    println(trie.search("app"))
}

private class Trie() {
    private val root = TrieNode()

    fun insert(word: String) {
        var current = root

        word.forEach { c ->
            current = current.children.getOrPut(c) {TrieNode()}
        }
        current.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        var current = root

        word.forEach { c ->
            val node = current.children[c] ?: return false
            current = node
        }
        return current.isEndOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var current = root

        prefix.forEach { c ->
            val node = current.children[c] ?: return false
            current = node
        }
        return true
    }
}

private class TrieNode {
    val children: MutableMap<Char, TrieNode> = hashMapOf()
    var isEndOfWord: Boolean = false
}

// https://leetcode.com/problems/implement-trie-prefix-tree/description/