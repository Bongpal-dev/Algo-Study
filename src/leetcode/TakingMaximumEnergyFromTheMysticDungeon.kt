package leetcode

fun main() {
    val (energy1, k1) = intArrayOf(5, 2, -10, -5, 1) to 3
    val (energy2, k2) = intArrayOf(-2, -3, -1) to 2
    val (energy3, k3) = intArrayOf(5, -10, 4, 3, 5, -9, 9, -7) to 2

    println(maximumEnergy(energy1, k1))
    println(maximumEnergy(energy2, k2))
    println(maximumEnergy(energy3, k3))
}

private fun maximumEnergy(energy: IntArray, k: Int): Int {
    val e = IntArray(energy.size)

    for (i in 0..k - 1) {
        e[i] = energy[i]
    }

    for (j in k..energy.lastIndex) {
        val prev = e[j - k]

        e[j] = maxOf(prev + energy[j], energy[j])
    }

    val start = e.size - k
    var ans = e[start]

    for (i in start..e.lastIndex) {
        ans = maxOf(ans, e[i])
    }

    return ans
}

// https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/description