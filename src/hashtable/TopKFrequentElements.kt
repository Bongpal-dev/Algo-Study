package hashtable

fun main() {
    val (nums1, k1) = intArrayOf(1,1,1,2,2,3) to 2
    val (nums2, k2) = intArrayOf(1) to 1
    val (nums3, k3) = intArrayOf(-1, -1) to 1

    println(topKFrequent(nums1, k1).joinToString())
    println(topKFrequent(nums2, k2).joinToString())
    println(topKFrequent(nums3, k3).joinToString())
}

private fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val answer = IntArray(k)
    val count = hashMapOf<Int, Int>()

    for (n in nums) {
        val c = count.getOrDefault(n, 0)

        count[n] = c + 1
    }

    count.toList().sortedByDescending { it.second }.let {
        for (i in 0..<k) {
            answer[i] = it[i].first
        }
    }
    return answer
}

// https://leetcode.com/problems/top-k-frequent-elements/description/