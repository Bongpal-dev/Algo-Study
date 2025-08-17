package leetcode

fun main() {
    val n1 = 3
    val n2 = 5
    val n3 = 15

    println(fizzBuzz(n1))
    println(fizzBuzz(n2))
    println(fizzBuzz(n3))
}

private fun fizzBuzz(n: Int): List<String> {
    val answer = mutableListOf<String>()

    for (i in 1..n) {
        answer += when {
            i % 3 == 0 && i % 5 == 0 -> "FizzBuzz"
            i % 3 == 0 -> "Fizz"
            i % 5 == 0 -> "Buzz"
            else -> i.toString()
        }
    }

    return answer
}

// https://leetcode.com/problems/fizz-buzz/description/