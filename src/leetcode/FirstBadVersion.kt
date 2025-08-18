package leetcode

fun main() {
    val (n1, bad1) = 5 to 4
    val (n2, bad2) = 1 to 1
    val (n3, bad3) = 2126753390 to 1702766719

    Solution(bad1).also { it.firstBadVersion(n1).run(::println) }
    Solution(bad2).also { it.firstBadVersion(n2).run(::println) }
    Solution(bad3).also { it.firstBadVersion(n3).run(::println) }
}

private abstract class VersionControl(private val bad: Int) {
    fun isBadVersion(version: Int) = version >= bad
    abstract fun firstBadVersion(n: Int): Int
}

private class Solution(bad: Int) : VersionControl(bad) {
    override fun firstBadVersion(n: Int): Int {
        var l = 0
        var r = n

        while (l < r) {
            val mid = l + (r - l) / 2

            if (isBadVersion(mid)) {
                r = mid
            } else {
                l = mid + 1
            }
        }

        return l
    }
}

// https://leetcode.com/problems/first-bad-version/description/