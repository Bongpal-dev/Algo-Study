package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "ljes=njak",
        "ddz=z=",
        "nljj",
        "c=c=",
        "dz=ak"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    var s = readLine()

    listOf("dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z=").forEach { s = s.replace(it, "a") }
    println(s.length)
}



