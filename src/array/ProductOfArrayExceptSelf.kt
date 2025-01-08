package array

fun main() {
    println(productExceptSelf(intArrayOf(1, 2, 3, 4)).joinToString())
    println(productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)).joinToString())
}

private fun productExceptSelf(nums: IntArray): IntArray {
    val answer = IntArray(nums.size) { 1 }
    var f = 1
    var e = 1

    for (i in nums.indices) {
        val l = i
        val r = nums.lastIndex - i

        if (l in 1..nums.lastIndex) answer[l] *= f
        if (r in 0..<nums.lastIndex) answer[r] *= e

        f *= nums[l]
        e *= nums[r]
    }

    return answer
}