package leetcode

fun main() {
    val nums1 = intArrayOf(21, 4, 7)
    val nums2 = intArrayOf(21, 21)
    val nums3 = intArrayOf(1, 2, 3, 4, 5)

    println(sumFourDivisors(nums1))
    println(sumFourDivisors(nums2))
    println(sumFourDivisors(nums3))
}

private fun sumFourDivisors(nums: IntArray): Int {
    return nums.sumOf { it.getDiv() }
}

private fun Int.getDiv(): Int {
    var count = 0
    var result = 0
    var i = 1

    while (i * i <= this) {
        if (this % i == 0) {
            val d = this / i

            count += if (i == d) 1 else 2
            result += if (i == d) i else (i + d)

            if (count > 4) return 0
        }

        i++
    }

    return if (count == 4) result else 0
}

// https://leetcode.com/problems/four-divisors/description/