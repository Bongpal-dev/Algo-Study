package leetcode

fun main() {
    val path1 = "/home/"
    val path2 = "/home//foo/"
    val path3 = "/home/user/Documents/../Pictures"
    val path4 = "/../"
    val path5 = "/.../a/../b/c/../d/./"

    println(simplifyPath(path1))
    println(simplifyPath(path2))
    println(simplifyPath(path3))
    println(simplifyPath(path4))
    println(simplifyPath(path5))
}

private fun simplifyPath(path: String): String {
    val answer = mutableListOf<String>()
    val route = path.split("/")

    for (d in route) {
        when {
            d.isBlank() || d == "." -> continue
            d == ".." -> answer.removeLastOrNull()
            else -> answer += d
        }
    }

    return answer.joinToString(prefix= "/", separator = "/")
}

// https://leetcode.com/problems/simplify-path/description/