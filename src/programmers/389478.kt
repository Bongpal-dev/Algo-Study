package programmers

fun main() {
    val (n1, w1, num1) = listOf(22, 6, 8)
    val (n2, w2, num2) = listOf(13, 3, 6)

    println(solution(n1, w1, num1))
    println(solution(n2, w2, num2))
}

private fun solution(n: Int, w: Int, num: Int): Int {
    val step = num.getStep(w)
    val total = n.getStep(w)
    val wPos = num.getWPosition(w, step)
    val maxPos = n.getWPosition(w, total)
    val isTopEmpty = if(total % 2 == 0) wPos >= maxPos else wPos <= maxPos
    val add = if(isTopEmpty) 1 else 0

    return total - step + add
}

private fun Int.getStep(w: Int): Int {
    val acc = this / w
    val added = if (this % w != 0) 1 else 0

    return acc + added
}

private fun Int.getWPosition(w: Int, step: Int): Int {
    val m = this - ((step - 1) * w)

    return if (step % 2 == 0) w - m else m
}

// https://school.programmers.co.kr/learn/courses/30/lessons/389478