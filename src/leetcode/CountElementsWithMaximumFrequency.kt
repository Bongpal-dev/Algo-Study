package leetcode

fun main() {
    val nums1 = intArrayOf(1, 2, 2, 3, 1, 4)
    val nums2 = intArrayOf(1, 2, 3, 4, 5)

    println(maxFrequencyElements(nums1))
    println(maxFrequencyElements(nums2))
}

private fun maxFrequencyElements(nums: IntArray): Int {
    val map = hashMapOf<Int, Int>()
    var (ans, max) = 0 to 0

    for (n in nums) {
        map.getOrDefault(n, 0)
            .plus(1)
            .also { map[n] = it }
            .let { c ->
                when {
                    c > max -> {
                        max = c
                        ans = c
                    }

                    c == max -> ans += c
                }
            }
    }

    return ans
}

// https://leetcode.com/problems/count-elements-with-maximum-frequency/description