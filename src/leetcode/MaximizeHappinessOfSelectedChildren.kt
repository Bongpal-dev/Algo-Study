package leetcode

fun main() {
    val (happiness1, k1) = intArrayOf(1, 2, 3) to 2
    val (happiness2, k2) = intArrayOf(1, 1, 1, 1) to 2
    val (happiness3, k3) = intArrayOf(2, 3, 4, 5) to 1

    println(maximumHappinessSum(happiness1, k1))
    println(maximumHappinessSum(happiness2, k2))
    println(maximumHappinessSum(happiness3, k3))
}

private fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
    var ans = 0L

    happiness.sortDescending()

    for (i in 0..<k) {
        if(happiness[i] - i <= 0) break

        ans += happiness[i] - i
    }

    return ans
}

// https://leetcode.com/problems/maximize-happiness-of-selected-children/description/