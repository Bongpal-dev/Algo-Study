package leetcode

fun main() {
    val s1 = "(()"
    val s2 = ")()())"
    val s3 = ""
    val s4 = "()(()"
    val s5 = "()(())"

    println(longestValidParentheses(s1))
    println(longestValidParentheses(s2))
    println(longestValidParentheses(s3))
    println(longestValidParentheses(s4))
    println(longestValidParentheses(s5))
}

private fun longestValidParentheses(s: String): Int {
    var answer = 0
    val stack = arrayListOf<Int>()

    stack += -1

    for (i in s.indices) {
        if (s[i] == '(') {
            stack += i
        } else {
            stack.removeLast()

            if (stack.isEmpty()) {
                stack += i
            } else {
                answer = maxOf(answer, i - stack.last())
            }
        }
    }

    return answer
}

 // https://leetcode.com/problems/longest-valid-parentheses/description/