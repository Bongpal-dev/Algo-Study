package leetcode

fun main() {
    val citations1 = intArrayOf(3, 0, 6, 1, 5)
    val citations2 = intArrayOf(1, 3, 1)

    println(hIndex(citations1))
    println(hIndex(citations2))
}

private fun hIndex(citations: IntArray): Int {
    citations.sortDescending()

    var h = 0

    for(i in citations.indices) {
        if(citations[i] >= i+1) {
            h = i + 1
        } else {
            break
        }
    }

    return h
}

// https://leetcode.com/problems/h-index/description/