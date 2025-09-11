package leetcode

import java.util.PriorityQueue
import java.util.TreeSet

fun main() {
    val s1 = "lEetcOde"
    val s2 = "lYmpH"

    println(sortVowels(s1))
    println(sortVowels(s2))
}

private fun sortVowels(s: String): String {
    val vovs = hashSetOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    val ans = CharArray(s.length)

    val nums = mutableListOf<Int>()
    val v = PriorityQueue<Char>()

    for (i in s.indices) {
        if (s[i] in vovs) {
            nums += i
            v += s[i]
        } else {
            ans[i] = s[i]
        }
    }

    nums.forEach { j ->
        ans[j] = v.poll()
    }

    return ans.joinToString("")
}

//https://leetcode.com/problems/sort-vowels-in-a-string/description