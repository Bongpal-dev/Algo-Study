package baekjoon

import java.io.ByteArrayInputStream

fun main() {
    val inputs = listOf(
        "26 5\nBulbasaur\nIvysaur\nVenusaur\nCharmander\nCharmeleon\nCharizard\nSquirtle\nWartortle\nBlastoise\nCaterpie\nMetapod\nButterfree\nWeedle\nKakuna\nBeedrill\nPidgey\nPidgeotto\nPidgeot\nRattata\nRaticate\nSpearow\nFearow\nEkans\nArbok\nPikachu\nRaichu\n25\nRaichu\n3\nPidgey\nKakuna"
    )

    println("------------------------------")
    inputs.forEach {
        System.setIn(ByteArrayInputStream(it.toByteArray()))
        solve()
        println("------------------------------")
    }
}

private fun solve() = with(System.`in`.bufferedReader()) {
    val n = readLine().substringBefore(" ").toInt()

    List(n) { readLine() to it + 1 }.let { pokemons ->
        val nameKey = pokemons.toMap()
        val numKey = pokemons.associate { it.second to it.first }

        readLines()
            .map { question ->
                if (question.first().isDigit()) numKey[question.toInt()] else nameKey[question]
            }
            .joinToString("\n")
            .run(::println)
    }
}

// https://www.acmicpc.net/problem/1620