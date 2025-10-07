package leetcode

import java.util.*
import kotlin.collections.HashMap

fun main() {
    val rains1 = intArrayOf(1, 2, 3, 4)
    val rains2 = intArrayOf(1, 2, 0, 0, 2, 1)
    val rains3 = intArrayOf(1, 2, 0, 1, 2)

    println(avoidFlood(rains1).joinToString())
    println(avoidFlood(rains2).joinToString())
    println(avoidFlood(rains3).joinToString())
}

private fun avoidFlood(rains: IntArray): IntArray {
    val ans = IntArray(rains.size) { 1 }
    val z = TreeSet<Int>()
    val water = HashMap<Int, Int>()

    for (i in rains.indices) {
        val rain = rains[i]

        if (rain == 0) {
            z.add(i)
            continue
        }
        ans[i] = -1

        val p = water[rain]

        if (p != null) {
            val d = z.ceiling(p + 1) ?: return intArrayOf()

            ans[d] = rain
            z.remove(d)
        }
        water[rain] = i
    }

    return ans
}

// https://leetcode.com/problems/avoid-flood-in-the-city/description