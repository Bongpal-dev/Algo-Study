package leetcode

fun main() {
    val nums1 = intArrayOf(4,3,2,1)
    val nums2 = intArrayOf(1,5,1,4,2)

    println(transformArray(nums1).joinToString())
    println(transformArray(nums2).joinToString())
}

private fun transformArray(nums: IntArray): IntArray {
    val ans = IntArray(nums.size)
    var o = nums.size - 1

    for(n in nums) {
        if(n % 2 != 0) {
            ans[o--] = 1
        }
    }

    return ans
}

// https://leetcode.com/problems/transform-array-by-parity/description/