package leetcode

fun main() {
    println(isArraySpecial(intArrayOf(1)))
    println(isArraySpecial(intArrayOf(2, 1, 4)))
    println(isArraySpecial(intArrayOf(4, 3, 1, 6)))
}

private fun isArraySpecial(nums: IntArray): Boolean {
    if (nums.size == 1) return true

    var isOdd = (nums[0] % 2 == 0).not()

    for (n in nums) {
        when {
            n % 2 == 0 && isOdd -> return false
            n % 2 != 0 && isOdd.not() -> return false
            else -> isOdd = n % 2 == 0
        }
    }

    return true
}

// https://leetcode.com/problems/special-array-i/description/