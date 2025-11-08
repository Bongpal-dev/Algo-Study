package leetcode

fun main() {
    val (hours1, target1) = intArrayOf(0, 1, 2, 3, 4) to 2
    val (hours2, target2) = intArrayOf(5, 1, 4, 2, 2) to 6

    println(numberOfEmployeesWhoMetTarget(hours1, target1))
    println(numberOfEmployeesWhoMetTarget(hours2, target2))
}

private fun numberOfEmployeesWhoMetTarget(hours: IntArray, target: Int): Int {
    return hours.count { it >= target }
}

// https://leetcode.com/problems/number-of-employees-who-met-the-target/description/