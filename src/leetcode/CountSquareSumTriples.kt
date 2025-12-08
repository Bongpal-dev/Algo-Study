package leetcode

fun main() {
    val n1 = 5
    val n2 = 10

    println(countTriples(n1))
    println(countTriples(n2))
}

private fun countTriples(n: Int): Int {
    var ans = 0
    val s = IntArray(n ) { (it + 1) * (it + 1) }

    for(a in 1 .. n) {
        val t = a * a

        for(b in s) {
            if(t <= b) break

            if(s.contains(t - b)) ans++
        }
    }

    return ans
}

// https://leetcode.com/problems/count-square-sum-triples/description/