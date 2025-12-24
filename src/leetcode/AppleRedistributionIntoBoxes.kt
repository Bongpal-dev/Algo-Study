package leetcode

fun main() {
    val (apple1, capacity1) = intArrayOf(1, 3, 2) to intArrayOf(4, 3, 1, 5, 2)
    val (apple2, capacity2) = intArrayOf(5, 5, 5) to intArrayOf(2, 4, 2, 7)

    println(minimumBoxes(apple1, capacity1))
    println(minimumBoxes(apple2, capacity2))
}

private fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
    var ans = 0
    var a = apple.sum()
    var i = 0

    capacity.sortDescending()

    while (a > 0) {
        a -= capacity[i]
        ans++
        i++
    }

    return ans
}

// https://leetcode.com/problems/apple-redistribution-into-boxes/description/