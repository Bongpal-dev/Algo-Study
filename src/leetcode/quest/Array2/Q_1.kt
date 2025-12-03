package leetcode.quest.Array2

fun main() {
    val nums1 = intArrayOf(1, 2, 2, 4)
    val nums2 = intArrayOf(1, 1)

    println(findErrorNums(nums1).joinToString())
    println(findErrorNums(nums2).joinToString())
}

private fun findErrorNums(nums: IntArray): IntArray {
    val ans = IntArray(2)

    val v = BooleanArray(nums.size + 1)

    for (n in nums) {
        if (v[n]) {
            ans[0] = n
        } else {
            v[n] = true
        }
    }

    for (j in 1..v.lastIndex) {
        if (v[j].not()) {
            ans[1] = j
            break
        }
    }

    return ans
}

// https://leetcode.com/problems/set-mismatch/description/