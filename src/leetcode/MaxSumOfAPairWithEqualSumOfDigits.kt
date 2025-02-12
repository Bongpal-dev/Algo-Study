package leetcode

fun main() {
    println(maximumSum(intArrayOf(18, 43, 36, 13, 7)))
    println(maximumSum(intArrayOf(10, 12, 19, 14)))
}

private fun maximumSum(nums: IntArray): Int {
    val sums = hashMapOf<Int, List<Int>>()

    for (n in nums) {
        val t = n.digitSum()
        val prev = sums.getOrDefault(t, emptyList())

        sums[t] = prev + n
    }

    sums.filterValues { it.size > 1 }.let { m ->
        if (m.isEmpty()) return -1

        m.map {
            it.value
                .sorted()
                .takeLast(2)
                .sum()
        }.let {
            return it.max()
        }
    }
}

fun Int.digitSum(): Int {
    var result = 0
    var n = this

    while (n > 0) {
        result += n % 10
        n /= 10
    }

    return result
}

// https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description