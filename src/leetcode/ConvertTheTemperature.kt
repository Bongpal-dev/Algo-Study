package leetcode

fun main() {
    val celsius1 = 36.50
    val celsius2 = 122.11

    println(convertTemperature(celsius1).joinToString())
    println(convertTemperature(celsius2).joinToString())
}

private fun convertTemperature(celsius: Double) = doubleArrayOf(celsius + 273.15, celsius * 1.80 + 32.00)

// https://leetcode.com/problems/convert-the-temperature/description/