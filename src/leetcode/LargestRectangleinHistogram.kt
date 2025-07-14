package leetcode

fun main() {
    val heights1 = intArrayOf(2,1,5,6,2,3)
    val heights2 = intArrayOf(2, 4)

    println(largestRectangleArea(heights1))
    println(largestRectangleArea(heights2))
}

private fun largestRectangleArea(heights: IntArray): Int {
    val nHeights = intArrayOf(0) + heights + intArrayOf(0)
    var answer = 0

    val stack = arrayListOf(0)

    for(i in 1 .. nHeights.lastIndex) {
        while(nHeights[i] < nHeights[stack.last()]) {
            val h = nHeights[stack.removeLast()]
            val prev = stack.last()
            val w = i - prev - 1

            answer = maxOf(answer, h * w)
        }
        stack.add(i)
    }

    return answer
}

// https://leetcode.com/problems/largest-rectangle-in-histogram/description/