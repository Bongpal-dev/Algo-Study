package leetcode

fun main() {
    val heights1 = arrayOf(
        intArrayOf(1, 2, 2, 3, 5),
        intArrayOf(3, 2, 3, 4, 4),
        intArrayOf(2, 4, 5, 3, 1),
        intArrayOf(6, 7, 1, 4, 5),
        intArrayOf(5, 1, 1, 2, 4),
    )
    val heights2 = arrayOf(intArrayOf(1))

    println(pacificAtlantic(heights1))
    println(pacificAtlantic(heights2))
}

private fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
    val ans = mutableListOf<List<Int>>()

    val m = heights.size
    val n = heights[0].size
    val p = Array(m) { BooleanArray(n) }
    val a = Array(m) { BooleanArray(n) }

    for (c in 0..<n) {
        find(0, c, Int.MIN_VALUE, heights, p)
        find(m - 1, c, Int.MIN_VALUE, heights, a)
    }

    for (r in 0..<m) {
        find(r, 0, Int.MIN_VALUE, heights, p)
        find(r, n - 1, Int.MIN_VALUE, heights, a)
    }

    for (r in 0..<m) {
        for (c in 0..<n) {
            if (p[r][c] && a[r][c]) ans += listOf(r, c)
        }
    }

    return ans
}

private fun find(r: Int, c: Int, prev: Int, heights: Array<IntArray>, visited: Array<BooleanArray>) {
    val m = heights.size
    val n = heights[0].size

    if (r !in 0..<m || c !in 0..<n) return

    val current = heights[r][c]

    if (visited[r][c] || current < prev) return

    visited[r][c] = true
    find(r + 1, c, current, heights, visited)
    find(r - 1, c, current, heights, visited)
    find(r, c + 1, current, heights, visited)
    find(r, c - 1, current, heights, visited)
}

// http://leetcode.com/problems/pacific-atlantic-water-flow/description