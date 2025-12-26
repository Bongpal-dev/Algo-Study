package leetcode

fun main() {
    val customers1 = "YYNY"
    val customers2 = "NNNNN"
    val customers3 = "YYYY"

    println(bestClosingTime(customers1))
    println(bestClosingTime(customers2))
    println(bestClosingTime(customers3))
}

private fun bestClosingTime(customers: String): Int {
    val sums = IntArray(customers.length + 1)
    var max = 0

    for (i in customers.indices) {
        sums[i + 1] = if (customers[i] == 'Y') sums[i] + 1 else sums[i] - 1
        max = maxOf(max, sums[i+1])
    }

    for (j in sums.indices) {
        if(sums[j] == max) return j
    }

    return -1
}

// https://leetcode.com/problems/minimum-penalty-for-a-shop/description/