package leetcode

fun main() {
    val n1 = 1
    val n2 = 1000
    val n3 = 3000

    println(nextBeautifulNumber(n1))
    println(nextBeautifulNumber(n2))
    println(nextBeautifulNumber(n3))
}

private fun nextBeautifulNumber(n: Int): Int {
    var ans = n + 1

    while (isBeautiful(ans).not()) ans++

    return ans
}

private fun isBeautiful(num: Int): Boolean {
    val count = IntArray(10)
    var r = num

    while (r > 0) {
        count[r % 10]++
        r /= 10
    }

    for (i in 0..9) {
        if (count[i] > 0 && count[i] != i) {
            return false
        }
    }

    return true
}

// https://leetcode.com/problems/next-greater-numerically-balanced-number/description/