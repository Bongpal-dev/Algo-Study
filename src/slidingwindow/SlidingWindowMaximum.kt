package slidingwindow

fun main() {
    val (nums1, k1) = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7) to 3
    val (nums2, k2) = intArrayOf(1) to 1
    val (nums3, k3) = intArrayOf(1, -1) to 1

    println(maxSlidingWindow(nums1, k1).joinToString())
    println(maxSlidingWindow(nums2, k2).joinToString())
    println(maxSlidingWindow(nums3, k3).joinToString())
}

private fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val answer = mutableListOf<Int>()
    val queue = ArrayDeque<Int>()

    for (i in nums.indices) {
        if (queue.isNotEmpty() && queue.first() <= i - k) queue.removeFirst()

        while (queue.isNotEmpty() && nums[queue.last()] < nums[i]) {
            queue.removeLast()
        }
        queue.add(i)

        if (i >= k-1) answer += nums[queue.first()]
    }

    return answer.toIntArray()
}

// https://leetcode.com/problems/sliding-window-maximum/description/