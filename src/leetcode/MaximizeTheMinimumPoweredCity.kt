package leetcode

fun main() {
    val stations1 = intArrayOf(1, 2, 4, 5, 0)
    val (r1, k1) = 1 to 2
    val stations2 = intArrayOf(4, 4, 4, 4)
    val (r2, k2) = 0 to 3

    println(maxPower(stations1, r1, k1))
    println(maxPower(stations2, r2, k2))
}

private fun maxPower(stations: IntArray, r: Int, k: Int): Long {
    val originPowers = stations.getPower(r)
    var min = 0L
    var max = originPowers.max() + k

    while (min < max) {
        val mid = (min + max + 1) / 2

        if(originPowers.canMakeMin(mid, r, k)) {
            min = mid
        } else {
            max = mid - 1
        }
    }

    return min
}

private fun IntArray.getPower(r: Int): LongArray {
    val sum = this.runningFold(0L) { acc, v -> acc + v.toLong() }

    return LongArray(this.size) { i ->
        val s = (i - r).coerceAtLeast(0)
        val e = (i + r).coerceAtMost(this.lastIndex)

        sum[e + 1] - sum[s]
    }
}

private fun LongArray.canMakeMin(min: Long, r: Int, k: Int): Boolean {
    var remain = k
    var added = 0L
    val end = LongArray(this.size + 1)

    for (i in this.indices) {
        val need = min - (this[i] + added)

        if (need > 0) {
            if(need > remain) return false

            val bp = minOf(this.lastIndex, i + r)
            val e = minOf(this.lastIndex, bp + r)

            remain -= need.toInt()
            added += need
            end[e] += need
        }

        added -= end[i]
    }

    return true
}

// https://leetcode.com/problems/maximize-the-minimum-powered-city/description/