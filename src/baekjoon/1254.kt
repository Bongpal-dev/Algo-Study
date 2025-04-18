package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "abab",
        "abacaba",
        "qwerty",
        "abdfhdyrbdbsdfghjkllkjhgfds"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val s = readLine()

    for (i in s.indices) {
        if (isPalindrome(s.substring(i))) {
            println(s.length + i)
            return
        }
    }
}

private fun isPalindrome(str: String): Boolean {
    var left = 0
    var right = str.length - 1

    while (left < right) {
        if (str[left] != str[right]) return false
        left++
        right--
    }

    return true
}

// https://www.acmicpc.net/problem/1254