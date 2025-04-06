package binarysearch

fun main() {
    val (n1, times1) = 6 to intArrayOf(7, 10)

    println(solution(n1, times1))
}

private fun solution(n: Int, times: IntArray): Long {
    var l = 1L
    val max = times.maxOrNull() ?: 0
    var h = max * n.toLong()
    var answer = h

    while (l <= h) {
        val mid = (l + h) / 2
        val perCheck = times.sumOf { mid / it.toLong() }

        if (perCheck >= n) {
            answer = mid
            h = mid - 1
        } else {
            l = mid + 1
        }
    }

    return answer
}

// https://school.programmers.co.kr/learn/courses/30/lessons/43238