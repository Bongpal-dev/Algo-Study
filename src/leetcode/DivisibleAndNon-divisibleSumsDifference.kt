package leetcode

fun main() {
    val (n1, m1) = 10 to 3
    val (n2, m2) = 5 to 6
    val (n3, m3) = 5 to 1

    println(differenceOfSums(n1, m1))
    println(differenceOfSums(n2, m2))
    println(differenceOfSums(n3, m3))
}

private fun differenceOfSums(n: Int, m: Int) = (1..n).sumOf { if(it % m != 0) it else it * -1 }

// https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/description/
