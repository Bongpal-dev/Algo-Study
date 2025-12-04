package leetcode

fun main() {
    val directions1 = "RLRSLL"
    val directions2 = "LLRR"

    println(countCollisions(directions1))
    println(countCollisions(directions2))
}

private fun countCollisions(directions: String): Int {
    var l = 0
    var r = directions.length - 1
    var ans = 0

    while(l <= r && directions[l] == 'L') l++
    while(l <= r && directions[r] == 'R') r--

    if(l > r) return 0

    for (i in l ..r) {
        if(directions[i] != 'S') ans++
    }

    return ans
}

// https://leetcode.com/problems/count-collisions-on-a-road/description/