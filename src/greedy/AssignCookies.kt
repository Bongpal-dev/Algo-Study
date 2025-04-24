package greedy

fun main() {
    val (g1, s1) = intArrayOf(1, 2, 3) to intArrayOf(1, 1)
    val (g2, s2) = intArrayOf(1, 2) to intArrayOf(1, 2, 3)
    val (g3, s3) = intArrayOf(1, 2, 3) to intArrayOf(3)

    println(findContentChildren(g1, s1))
    println(findContentChildren(g2, s2))
    println(findContentChildren(g3, s3))
}

private fun findContentChildren(g: IntArray, s: IntArray): Int {
    var answer = 0
    var gi = 0
    var si = 0

    g.sort()
    s.sort()

    while (si < s.size && gi < g.size) {
        if (g[gi] <= s[si]) {
            answer++
            gi++
            si++
        } else {
            si++
        }
    }

    return answer
}

// https://leetcode.com/problems/assign-cookies/description/