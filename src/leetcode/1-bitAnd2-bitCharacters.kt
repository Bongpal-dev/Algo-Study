package leetcode

fun main() {
    val bits1 = intArrayOf(1, 0, 0)
    val bits2 = intArrayOf(1, 1, 1, 0)

    println(isOneBitCharacter(bits1))
    println(isOneBitCharacter(bits2))
}

private fun isOneBitCharacter(bits: IntArray): Boolean {
    val size = bits.size
    var i = 0

    while (i < size - 1) {
        if (bits[i] == 1) i += 2 else i++
    }

    return i < size
}

// https://leetcode.com/problems/1-bit-and-2-bit-characters/description/