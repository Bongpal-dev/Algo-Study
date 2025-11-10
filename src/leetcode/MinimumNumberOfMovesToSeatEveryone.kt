package leetcode

import kotlin.math.absoluteValue

fun main() {
    val (seats1, students1) = intArrayOf(3,1,5) to intArrayOf(2,7,4)
    val (seats2, students2) = intArrayOf(4,1,5,9) to intArrayOf(1,3,2,6)
    val (seats3, students3) = intArrayOf(2,2,6,6) to intArrayOf(1,3,2,6)

    println(minMovesToSeat(seats1, students1))
    println(minMovesToSeat(seats2, students2))
    println(minMovesToSeat(seats3, students3))
}

private fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
    var ans = 0

    seats.sort()
    students.sort()

    for(i in seats.indices) {
        ans += (seats[i] - students[i]).absoluteValue
    }

    return ans
}

// https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/