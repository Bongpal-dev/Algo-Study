package leetcode

fun main() {
    val bank1 = arrayOf("011001", "000000", "010100", "001000")
    val bank2 = arrayOf("000", "111", "000")

    println(numberOfBeams(bank1))
    println(numberOfBeams(bank2))
}

private fun numberOfBeams(bank: Array<String>): Int {
    val leasers = bank.map { it.count { c -> c == '1' } }
    var ans = 0
    var prev = 0

    for(l in leasers) {
        if(l > 0) {
            ans += prev * l
            prev = l
        }
    }

    return ans
}

// https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/