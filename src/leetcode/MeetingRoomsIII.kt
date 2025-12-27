package leetcode

import java.util.*

fun main() {
    val (n1, meetings1) = 2 to arrayOf(
        intArrayOf(0, 10),
        intArrayOf(1, 5),
        intArrayOf(2, 7),
        intArrayOf(3, 4),
    )
    val (n2, meetings2) = 3 to arrayOf(
        intArrayOf(1, 20),
        intArrayOf(2, 10),
        intArrayOf(3, 5),
        intArrayOf(4, 9),
        intArrayOf(6, 8),
    )

    println(mostBooked(n1, meetings1))
    println(mostBooked(n2, meetings2))
}

private fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
    var ans = 0
    val empty = PriorityQueue<Int>()
    val use = PriorityQueue<Room>(compareBy({ it.end }, { it.num }))
    val count = IntArray(n)

    meetings.sortBy { it[0] }

    for (i in 0 until n) empty += i

    for (m in meetings) {
        val s = m[0].toLong()
        val e = m[1].toLong()
        val d = e - s

        while (use.isNotEmpty() && use.peek().end <= s) {
            val p = use.poll()

            empty.add(p.num)
        }

        if (empty.isNotEmpty()) {
            val room = empty.poll()

            count[room]++
            use += Room(room, e)
        } else {
            val endRoom = use.poll()

            count[endRoom.num]++
            use += Room(endRoom.num, endRoom.end + d)
        }
    }

    for (i in 1 until n) {
        if (count[ans] < count[i]) ans = i
    }

    return ans
}

private data class Room(
    val num: Int,
    val end: Long
)

// https://leetcode.com/problems/meeting-rooms-iii/description/