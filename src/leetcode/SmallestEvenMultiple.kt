package leetcode

fun main() {
    val n1 = 5
    val n2 = 6

    println(smallestEvenMultiple(n1))
    println(smallestEvenMultiple(n2))
}

private fun smallestEvenMultiple(n: Int) = if(n % 2 == 0) n  else n * 2