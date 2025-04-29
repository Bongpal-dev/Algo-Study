package divideandconquer

fun main() {
    val expression1 = "2-1-1"
    val expression2 = "2*3-4*5"
    val expression3 = "2*3-4*5+1"

    println(diffWaysToCompute(expression1))
    println(diffWaysToCompute(expression2))
    println(diffWaysToCompute(expression3))
}

private val memo = mutableMapOf<String, List<Int>>()

private fun diffWaysToCompute(expression: String): List<Int> {
    if (expression in memo) return memo[expression]!!

    val results = mutableListOf<Int>()

    for (i in expression.indices) {
        val crtChar = expression[i]

        if (crtChar.isOperator()) {
            val leftResults = diffWaysToCompute(expression.substring(0, i))
            val rightResults = diffWaysToCompute(expression.substring(i + 1))

            leftResults.forEach { l ->
                rightResults.forEach { r ->
                    results += crtChar.operate(l, r)
                }
            }
        }
    }

    if (results.isEmpty()) results.add(expression.toInt())

    memo[expression] = results

    return results
}

private fun Char.isOperator() = this == '+' || this == '-' || this == '*'

private fun Char.operate(a: Int, b: Int): Int {
    return when (this) {
        '+' -> a + b
        '-' -> a - b
        else -> a * b
    }
}

// https://leetcode.com/problems/different-ways-to-add-parentheses/description/