package string

private fun main() {
    val case1 = charArrayOf('h', 'e', 'l', 'l', 'o')
    val case2 = charArrayOf('h', 'a', 'n', 'n', 'a', 'h')

    reverseString(case1)
    reverseString(case2)

    println(case1)
    println(case2)
}

private fun reverseString(s: CharArray): Unit {
    var l = 0
    var r = s.size -1

    while (l <= r) {
        s[l] = s[r].also { s[r] = s[l] }
        l++
        r--
    }
}

// https://leetcode.com/problems/reverse-string/description/