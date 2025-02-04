package hashtable

fun main() {
    val (jewels1, stones1) = "aA" to "aAAbbbb"
    val (jewels2, stones2) = "z" to "ZZ"

    println(numJewelsInStones(jewels1, stones1))
    println(numJewelsInStones(jewels2, stones2))
}

private fun numJewelsInStones(jewels: String, stones: String): Int {
    val t = hashMapOf<Char, Char>()

    for (j in jewels) {
        t[j] = j
    }

    return stones.count { s -> t[s] != null }
}

// https://leetcode.com/problems/jewels-and-stones/description/