package leetcode

fun main() {
    val (skill1, mana1) = intArrayOf(1, 5, 2, 4) to intArrayOf(5, 1, 4, 2)
    val (skill2, mana2) = intArrayOf(1, 1, 1) to intArrayOf(1, 1, 1)
    val (skill3, mana3) = intArrayOf(1, 2, 3, 4) to intArrayOf(1, 2)

    println(minTime(skill1, mana1))
    println(minTime(skill2, mana2))
    println(minTime(skill3, mana3))
}

private fun minTime(skill: IntArray, mana: IntArray): Long {
    val t = LongArray(skill.size + 1)
    var start = 0L

    for (i in skill.indices) {
        t[i + 1] = t[i] + skill[i]
    }

    for (m in 0..<mana.lastIndex) {
        var sub = 0L

        for (s in skill.indices) {
            val need = (t[s + 1] * mana[m]) - (t[s] * mana[m + 1])

            if(need > sub) sub = need
        }

        if(sub > 0L) start += sub
    }

    return start + t.last() * mana.last()
}

// https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/description