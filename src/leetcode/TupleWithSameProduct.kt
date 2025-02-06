package leetcode

fun main() {
    println(tupleSameProduct(intArrayOf(2, 3, 4, 6)))
    println(tupleSameProduct(intArrayOf(1, 2, 4, 5, 10)))
    println(tupleSameProduct(intArrayOf(2, 3, 4, 6, 8, 12)))
}

private fun tupleSameProduct(nums: IntArray): Int {
    var answer = 0
    val count = hashMapOf<Int, List<IntArray>>()

    for (n in nums) {
        for (m in nums) {
            if (n != m) {
                val prev = count.getOrDefault(n * m, emptyList())

                count[n * m] = prev + intArrayOf(n, m)
            }
        }
    }

    count
        .filterValues { it.size > 2 }.values
        .forEach { answer += it.size * (it.size - 2) }

    return answer
}

// https://leetcode.com/problems/tuple-with-same-product/description/