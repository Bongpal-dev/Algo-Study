package leetcode

fun main() {
    val nums1 = intArrayOf(0,1,1,0)
    val nums2 = intArrayOf(0,3,2,1,3,2)
    val nums3 = intArrayOf(7,1,5,4,3,4,6,0,9,5,8,2)

    println(getSneakyNumbers(nums1).joinToString())
    println(getSneakyNumbers(nums2).joinToString())
    println(getSneakyNumbers(nums3).joinToString())
}

private fun getSneakyNumbers(nums: IntArray): IntArray {
    val ans = IntArray(2)
    val exist = BooleanArray(101)
    var count = 0

    for(n in nums) {
        if(exist[n].not()) {
            exist[n] = true
            continue
        }

        ans[count++] = n

        if(count == 2) break
    }

    return ans
}

// https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/description/