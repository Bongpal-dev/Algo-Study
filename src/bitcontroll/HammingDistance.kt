package bitcontroll

fun main() {
    val (x1, y1) = 1 to 4
    val (x2, y2) = 3 to 1

    println(hammingDistance(x1, y1))
    println(hammingDistance(x2, y2))
}

private fun hammingDistance(x: Int, y: Int): Int {
    var answer = 0
    var num = x.xor(y)

    while (num > 0) {
        if (num % 2 != 0) answer++

        num /= 2
    }

    return answer
}

// https://leetcode.com/problems/hamming-distance/description/