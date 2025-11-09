package leetcode

fun main() {
    val (num11, num21) = 2 to 3
    val (num12, num22) = 10 to 10

    println(countOperations(num11, num21))
    println(countOperations(num12, num22))
}

private fun countOperations(num1: Int, num2: Int): Int {
    var ans = 0
    var rm1 = num1
    var rm2 = num2

    while(rm1 > 0 && rm2 > 0) {
        if(rm1 >= rm2) {
            ans += rm1 / rm2
            rm1 %= rm2
        } else {
            ans += rm2 / rm1
            rm2 %= rm1
        }
    }

    return ans
}

// https://leetcode.com/problems/count-operations-to-obtain-zero/description/