package leetcode

fun main() {
    val pref1 = intArrayOf(5, 2, 0, 3, 1)
    val pref2 = intArrayOf(13)

    println(findArray(pref1).joinToString())
    println(findArray(pref2).joinToString())
}

private fun findArray(pref: IntArray): IntArray {
    val ans = IntArray(pref.size)

    ans[0] = pref[0]

    for (i in 1 .. pref.lastIndex) {
        ans[i] = pref[i-1].xor(pref[i])
    }

    return ans
}

// https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/