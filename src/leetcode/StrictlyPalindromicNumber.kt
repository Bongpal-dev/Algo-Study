package leetcode

fun main() {
    val n1 = 9
    val n2 = 4

    println(isStrictlyPalindromic(n1))
    println(isStrictlyPalindromic(n2))
}

private fun isStrictlyPalindromic(n: Int): Boolean {
    for (i in 2..n - 2) {
        n.toString(i).let{
            if(it.isPalindrome().not()) return false
        }
    }

    return true
}

private fun String.isPalindrome() = this == this.reversed()

// https://leetcode.com/problems/strictly-palindromic-number/description/