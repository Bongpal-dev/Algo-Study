package leetcode

fun main() {
    val target1 = intArrayOf(1, 2, 3, 2, 1)
    val target2 = intArrayOf(3, 1, 1, 2)
    val target3 = intArrayOf(3, 1, 5, 4, 2)

    println(minNumberOperations(target1))
    println(minNumberOperations(target2))
    println(minNumberOperations(target3))
}

private fun minNumberOperations(target: IntArray): Int {
    var ans = target[0]

    for (i in 1..target.lastIndex) {
        if (target[i] > target[i - 1]) ans += target[i] - target[i - 1]
    }

    return ans
}

// https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/description/