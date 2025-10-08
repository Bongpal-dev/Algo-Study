package leetcode

fun main() {
    val (spells1, potions1) = intArrayOf(5, 1, 3) to intArrayOf(1, 2, 3, 4, 5)
    val success1 = 7L
    val (spells2, potions2) = intArrayOf(3, 1, 2) to intArrayOf(8, 5, 8)
    val success2 = 16L

    println(successfulPairs(spells1, potions1, success1).joinToString())
    println(successfulPairs(spells2, potions2, success2).joinToString())
}

private fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
    val ans = IntArray(spells.size)

    potions.sort()
    spells.forEachIndexed { i, s ->
        val n = (success + s - 1) / s
        val si = potions.findIndex(n)

        ans[i] = potions.size - si
    }

    return ans
}

private fun IntArray.findIndex(v: Long): Int {
    var s = 0
    var l = this.size

    while (s < l) {
        val mid = (s + l).ushr(1)

        if (this[mid].toLong() < v) {
            s = mid + 1
        } else {
            l = mid
        }
    }

    return s
}

// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description