package leetcode

fun main() {
    val n1 = 6
    val n2 = 1
    val n3 = 14

    println(isUgly(n1))
    println(isUgly(n2))
    println(isUgly(n3))
}

private fun isUgly(n: Int): Boolean {
    var num = n

    while(num > 1) {
        num /= when{
            num %2 == 0 -> 2
            num %3 == 0 -> 3
            num %5 == 0 -> 5
            else -> return false
        }
    }

    return num == 1
}

// https://leetcode.com/problems/ugly-number/description/