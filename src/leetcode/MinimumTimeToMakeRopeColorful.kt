package leetcode

fun main() {
    val (colors1, neededTime1) = "abaac" to intArrayOf(1, 2, 3, 4, 5)
    val (colors2, neededTime2) = "abc" to intArrayOf(1, 2, 3)
    val (colors3, neededTime3) = "aabaa" to intArrayOf(1, 2, 3, 4, 1)
    val (colors4, neededTime4) = "aaabbbabbbb" to intArrayOf(3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1)

    println(minCost(colors1, neededTime1))
    println(minCost(colors2, neededTime2))
    println(minCost(colors3, neededTime3))
    println(minCost(colors4, neededTime4))
}

private fun minCost(colors: String, neededTime: IntArray): Int {
    var ans = 0
    var i = 0

    while(i < colors.length) {
        var j = i
        var sum = 0
        var max = 0

        while(j < colors.length && colors[i] == colors[j]) {
            sum += neededTime[j]
            max = maxOf(max, neededTime[j])
            j++
        }

        if(j - i > 1) {
            ans += sum - max
        }

        i = j
    }

    return ans
}

// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/