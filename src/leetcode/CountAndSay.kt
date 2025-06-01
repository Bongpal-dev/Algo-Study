package leetcode

fun main() {
    val n1 = 4
    val n2 = 1

    println(countAndSay(n1))
    println(countAndSay(n2))
}

private fun countAndSay(n: Int): String {
    if (n == 1) return "1"

    var s = "1"

    repeat(n - 1) {
        var i = 0
        var sb = StringBuilder()

        while (i < s.length) {
            val current = s[i]
            var cnt = 1

            while (i + 1 < s.length && s[i + 1] == current) {
                cnt++
                i++
            }

            sb.append(cnt)
            sb.append(current)
            i++
        }

        s = sb.toString()
    }

    return s
}

// https://leetcode.com/problems/count-and-say/description/