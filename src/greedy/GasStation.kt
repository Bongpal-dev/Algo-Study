package greedy

import kotlin.math.tan

fun main() {
    val (gas1, cost1) = intArrayOf(1, 2, 3, 4, 5) to intArrayOf(3, 4, 5, 1, 2)
    val (gas2, cost2) = intArrayOf(2, 3, 4) to intArrayOf(3, 4, 3)

    println(canCompleteCircuit(gas1, cost1))
    println(canCompleteCircuit(gas2, cost2))
}

private fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    var total = 0
    var tank = 0
    var start = 0

    for (i in gas.indices) {
        val diff = gas[i] - cost[i]

        total += diff
        tank += diff

        if (tank < 0) {
            start = i + 1
            tank = 0
        }
    }

    return if (total >= 0) start else -1
}

// https://leetcode.com/problems/gas-station/description/