package heap

fun main() {
    val (nums1, k1) = intArrayOf(3, 2, 1, 5, 6, 4) to 2
    val (nums2, k2) = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6) to 4

    println(findKthLargest(nums1, k1))
    println(findKthLargest(nums2, k2))
}

private fun findKthLargest(nums: IntArray, k: Int): Int {
    nums.heapSort()

    return nums[k-1]
}

private fun IntArray.heapSort() {
    for (i in 1..this.lastIndex) {
        var c = i

        while (c > 0) {
            val root = (c - 1) / 2

            if (this[root] > this[c]) {
                this[root] = this[c].also { this[c] = this[root] }
            }
            c = root
        }
    }

    for (j in this.lastIndex downTo 0) {
        this[j] = this[0].also { this[0] = this[j] }

        var root = 0
        var current = 1

        while (current < j) {
            current = 2 * root + 1

            if (current < j - 1 && this[current] > this[current + 1]) {
                current++
            }

            if (current < j && this[root] > this[current]) {
                this[root] = this[current].also { this[current] = this[root] }
            }
            root = current
        }
    }
}

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/