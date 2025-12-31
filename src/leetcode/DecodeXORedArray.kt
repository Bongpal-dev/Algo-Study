package leetcode

fun main() {
    val (encoded1, first1) = intArrayOf(1, 2, 3) to 1
    val (encoded2, first2) = intArrayOf(6, 2, 7, 3) to 4

    println(decode(encoded1, first1).joinToString())
    println(decode(encoded2, first2).joinToString())
}

private fun decode(encoded: IntArray, first: Int): IntArray {
    val ans = IntArray(encoded.size + 1)

    ans[0] = first

    for(i in 1 .. ans.lastIndex) {
        ans[i] = ans[i-1].xor(encoded[i-1])
    }

    return ans
}

// https://leetcode.com/problems/decode-xored-array/description/