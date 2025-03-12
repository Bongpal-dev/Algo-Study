package tree

fun main() {
    val nums1 = intArrayOf(-10, -3, 0, 5, 9)
    val nums2 = intArrayOf(1, 3)

    println(sortedArrayToBST(nums1).toList())
    println(sortedArrayToBST(nums2).toList())
}

private fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if (nums.size == 1) return TreeNode(nums.first())

    return generate(0, nums.lastIndex, nums)
}

private fun generate(s: Int, e: Int, nums: IntArray): TreeNode? {
    if (s > e) return null

    val mid = s + (e - s) / 2
    val node = TreeNode(nums[mid])

    node.left = generate(s, mid -1, nums)
    node.right = generate(mid+1, e, nums)

    return node
}

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/