package leetcode

fun main() {
    val n1 = 43261596
    val n2 = 2147483644

    println(reverseBits(n1))
    println(reverseBits(n2))
}

private fun reverseBits(n: Int): Int {
    var answer = 0
    val s = n.toString(2).padStart(32, '0')
    var d = 1

    for (i in s.indices) {
        if(s[i] == '1') answer += d

        d *= 2
    }

    return answer
}

// https://leetcode.com/problems/reverse-bits/description/