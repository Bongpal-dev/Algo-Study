package leetcode

fun main() {
    val s1 = "25525511135"
    val s2 = "0000"
    val s3 = "101023"

    println(restoreIpAddresses(s1))
    println(restoreIpAddresses(s2))
    println(restoreIpAddresses(s3))
}

private fun restoreIpAddresses(s: String): List<String> {
    val answer = mutableListOf<String>()

    fun generate(start: Int, path: List<String>) {
        if (path.size == 4 && start == s.length) {
            answer += path.joinToString(".")
            return
        }

        if (path.size == 4 || start >= s.length) return

        for (l in 1..3) {
            if (start + l > s.length) break

            val p = s.substring(start, start + l)

            if (isValid(p)) {
                generate(start + l, path + p)
            }
        }
    }
    generate(0, listOf())

    return answer
}

private fun isValid(s: String): Boolean {
    return when {
        s.isEmpty() || s.length > 3 -> false
        s.startsWith("0") && s.length > 1 -> false
        else -> s.toInt() in 0 .. 255
    }
}

// https://leetcode.com/problems/restore-ip-addresses/description/