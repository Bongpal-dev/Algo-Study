package leetcode

fun main() {
    val k1 = 1
    val k2 = 2
    val k3 = 3

    println(smallestRepunitDivByK(k1))
    println(smallestRepunitDivByK(k2))
    println(smallestRepunitDivByK(k3))
}

private fun smallestRepunitDivByK(k: Int): Int {
    if(k % 2 == 0 || k % 5 == 0) return -1

    var r = 0

    for (len in 1..k) {
        r = (r * 10 + 1) % k

        if (r == 0) return len
    }

    return -1
}

// https://leetcode.com/problems/smallest-integer-divisible-by-k/description/