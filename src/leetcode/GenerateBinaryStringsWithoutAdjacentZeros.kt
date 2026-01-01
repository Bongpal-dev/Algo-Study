package leetcode

fun main() {
    val n1 = 3
    val n2 = 1

    println(validStrings(n1))
    println(validStrings(n2))
}

private fun validStrings(n: Int): List<String> {
    val ans = mutableListOf<String>()

    dfs(n, "0", ans)
    dfs(n, "1", ans)

    return ans
}

private fun dfs(n: Int, c: String, ans: MutableList<String>) {
    if(c.length == n) {
        ans += c
        return
    }

    val last = c.last()

    if(last == '1') dfs(n, c + "0", ans)

    dfs(n, c + "1", ans)
}

// https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/description/