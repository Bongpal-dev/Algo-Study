package leetcode

fun main() {
    val num1 = 9669
    val num2 = 9996
    val num3 = 9999

    println(maximum69Number(num1))
    println(maximum69Number(num2))
    println(maximum69Number(num3))
}

private fun maximum69Number(num: Int): Int {
    var r = num
    var p = 1
    var mP = 0

    while(r > 0) {
        val c = r % 10

        if(c == 6) mP = p

        r/= 10
        p *= 10
    }

    return if(mP == 0) num else num + (3 * mP)
}

// https://leetcode.com/problems/maximum-69-number/description/