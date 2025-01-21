package stack

fun main() {
    val case1 = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
    val case2 = intArrayOf(30, 40, 50, 60)
    val case3 = intArrayOf(30, 60, 90)

    println(dailyTemperatures(case1).joinToString())
    println(dailyTemperatures(case2).joinToString())
    println(dailyTemperatures(case3).joinToString())
}

private fun dailyTemperatures(temperatures: IntArray): IntArray {
    val stack = mutableListOf<Pair<Int, Int>>()
    val answer = IntArray(temperatures.size) { 0 }
    var i = 0

    while (i < temperatures.size) {
        val last = stack.lastOrNull()

        if (last != null && last.second < temperatures[i]) {
            answer[last.first] = i - last.first
            stack.removeLast()
        } else {
            stack.add(i to temperatures[i])
            i++
        }
    }

    return answer
}

// https://leetcode.com/problems/daily-temperatures/description/