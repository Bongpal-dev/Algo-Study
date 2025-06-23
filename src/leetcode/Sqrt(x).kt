package leetcode

fun main() {
    val x1 = 4
    val x2 = 8
    val x3 = 9

    println(mySqrt(x1))
    println(mySqrt(x2))
    println(mySqrt(x3))
}

private fun mySqrt(x: Int): Int {
    if (x == 0 || x == 1) return x

    var s = 0
    var e = x
    var answer = 0

    while (s <= e) {
        val mid = (s + e) / 2
        val n = mid.toLong() * mid

        when {
            n == x.toLong() -> return mid
            n < x -> {
                answer = mid
                s = mid + 1
            }

            else -> e = mid - 1
        }
    }

    return answer
}

// https://leetcode.com/problems/sqrtx/description/