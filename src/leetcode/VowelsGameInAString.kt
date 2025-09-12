package leetcode

fun main() {
    val s1 = "leetcoder"
    val s2 = "bbcd"

    println(doesAliceWin(s1))
    println(doesAliceWin(s2))
}

private fun doesAliceWin(s: String): Boolean {
    val vovs = hashSetOf('a', 'e', 'i', 'o', 'u')

    return s.any { it in vovs }
}

// https://leetcode.com/problems/vowels-game-in-a-string/description