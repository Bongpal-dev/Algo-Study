package leetcode

fun main() {
    val power1 = intArrayOf(1, 1, 3, 4)
    val power2 = intArrayOf(7, 1, 6, 6)

    println(maximumTotalDamage(power1))
    println(maximumTotalDamage(power2))
}

private fun maximumTotalDamage(power: IntArray): Long {
    val map = HashMap<Int, Long>()

    for (p in power) {
        val v = map[p] ?: 0L

        map[p] = v + p.toLong()
    }

    val ds = map.keys.sorted()
    val prev = IntArray(ds.size) { -1 }
    var pi = 0

    for (i in ds.indices) {
        while (pi < i && ds[i] - ds[pi] >= 3) pi++

        prev[i] = pi - 1
    }

    val dp = LongArray(ds.size)

    dp[0] = map[ds[0]] ?: 0L

    for (k in 1 until ds.size) {
        val dmg = map[ds[k]] ?: 0
        val sum = dmg + if (prev[k] >= 0) dp[prev[k]] else 0L

        dp[k] = maxOf(sum, dp[k - 1])
    }

    return dp.last()
}

// https://leetcode.com/problems/maximum-total-damage-with-spell-casting/description