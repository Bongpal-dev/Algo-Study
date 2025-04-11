package bitcontroll

fun main() {
    val data1 = intArrayOf(197, 130, 1)
    val data2 = intArrayOf(235, 140, 4)

    println(validUtf8(data1))
    println(validUtf8(data2))
}

private fun validUtf8(data: IntArray): Boolean {
    var i = 0

    while (i < data.size) {
        val byte = data[i]
        val bit8 = byte.and(0xFF)
        val byteCount = when {
            bit8.and(0b10000000) == 0b00000000 -> 1
            bit8.and(0b11100000) == 0b11000000 -> 2
            bit8.and(0b11110000) == 0b11100000 -> 3
            bit8.and(0b11111000) == 0b11110000 -> 4
            else -> return false
        }

        if (i + byteCount > data.size) return false

        for (j in 1 until byteCount) {
            val next = data[i+j].and(0xFF)

            if (next.and(0b11000000) != 0b10000000) return false
        }

        i += byteCount
    }

    return true
}

// https://leetcode.com/problems/utf-8-validation/description/