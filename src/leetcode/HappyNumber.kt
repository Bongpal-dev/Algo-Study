package leetcode

fun main() {
    val n1 = 19
    val n2 = 2

    println(isHappy(n1))
    println(isHappy(n2))
}

private fun isHappy(n: Int): Boolean {
    val set = hashSetOf<Int>()
    var happyNum = n

    while(happyNum != 1) {
        var remain = happyNum
        var currentNum = 0

        while(remain > 0) {
            val n = remain % 10

            currentNum += n*n
            remain /= 10
        }

        if(currentNum in set) return false

        set += currentNum
        happyNum = currentNum
    }

    return true
}

// https://leetcode.com/problems/happy-number/description/