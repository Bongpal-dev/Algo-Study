package leetcode

fun main() {
    val nums1 = intArrayOf(2, 6, 3, 4)
    val nums2 = intArrayOf(2, 10, 6, 14)
    val nums3 = intArrayOf(6, 10, 15)

    println(minOperations(nums1))
    println(minOperations(nums2))
    println(minOperations(nums3))
}

private fun minOperations(nums: IntArray): Int {
    var o = 0
    var g = 0

    nums.forEach { n ->
        if (n == 1) o++

        g = gcd(g, n)
    }

    return when {
        o > 0 -> nums.size - o
        g != 1 -> -1
        else -> nums.findMin() + nums.size - 2
    }
}

private fun IntArray.findMin(): Int {
    var min = Int.MAX_VALUE
    var prev = mutableMapOf<Int, Int>()

    this.forEach { n ->
        val current = mutableMapOf<Int, Int>().apply { set(n, 1) }

        prev.forEach { (g, c) ->
            val nGcd = gcd(g, n)
            val count = c + 1

            if (current[nGcd] == null || count < current[nGcd]!!) current[nGcd] = count
        }
        current[1]?.let { min = minOf(min, it) }

        prev = current
    }

    return min
}

private fun gcd(a: Int, b: Int): Int = if (a % b == 0) b else gcd(b, a % b)

// https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/description/