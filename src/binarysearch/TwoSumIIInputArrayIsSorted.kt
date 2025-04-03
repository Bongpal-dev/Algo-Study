package binarysearch

fun main() {
    val (numbers1, target1) = intArrayOf(2, 7, 11, 15) to 9
    val (numbers2, target2) = intArrayOf(2, 3, 4) to 6
    val (numbers3, target3) = intArrayOf(-1, 0) to -1

    println(twoSum(numbers1, target1).joinToString())
    println(twoSum(numbers2, target2).joinToString())
    println(twoSum(numbers3, target3).joinToString())
}

private fun twoSum(numbers: IntArray, target: Int): IntArray {
    val answer = IntArray(2) { 0 }

    for (i in numbers.indices) {
        val t = target - numbers[i]

        binarySearch(numbers, t, i + 1, numbers.lastIndex)?.let {
            answer[0] = i + 1
            answer[1] = it + 1
            return answer
        }
    }

    return answer
}

private fun binarySearch(nums: IntArray, t: Int, s: Int, e: Int): Int? {
    var l = s
    var h = e
    var mid: Int

    while (l <= h) {
        mid = (l + h) / 2

        if (nums[mid] == t) return mid

        if (nums[mid] < t) {
            l = mid + 1
        } else {
            h = mid - 1
        }
    }

    return null
}

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/