package leetcode.quest.stack

fun main() {
    val (target1, n1) = intArrayOf(1, 3) to 3
    val (target2, n2) = intArrayOf(1, 2, 3) to 3
    val (target3, n3) = intArrayOf(1, 2) to 4

    println(buildArray(target1, n1))
    println(buildArray(target2, n2))
    println(buildArray(target3, n3))
}

private fun buildArray(target: IntArray, n: Int): List<String> {
    val ans = mutableListOf<String>()
    var i = 0

    for (n in 1..n) {
        if(i > target.lastIndex) break

        ans += "Push"

        if (target[i] == n) {
            i++
        } else {
            ans += "Pop"
        }
    }

    return ans
}

// https://leetcode.com/problems/build-an-array-with-stack-operations/description/