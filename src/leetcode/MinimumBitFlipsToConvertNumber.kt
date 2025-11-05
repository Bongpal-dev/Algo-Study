package leetcode

fun main() {
    val (start1, goal1) = 10 to 7
    val (start2, goal2) = 3 to 4

    println(minBitFlips(start1, goal1))
    println(minBitFlips(start2, goal2))
}

private fun minBitFlips(start: Int, goal: Int): Int {
    var ans = 0

    var sr = start
    var gr = goal

    while (sr > 0 || gr > 0) {
        if(sr.and(1) != gr.and(1)) ans++

        sr = sr.shr(1)
        gr = gr.shr(1)
    }

    return ans
}

// https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/