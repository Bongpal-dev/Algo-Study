package stack

fun main() {
    println(removeDuplicateLetters("bcabc"))
    println(removeDuplicateLetters("cbacdcbc"))
    println(removeDuplicateLetters("cdadabcc"))
    println(removeDuplicateLetters("cbbbcaa"))
    println(removeDuplicateLetters("abacb"))
}

val Char.index get() = run { this.code - 97 }

private fun removeDuplicateLetters(s: String): String {
    val count = s.countEachElement()
    val stack = mutableListOf<Char>()
    val visit = IntArray(26) { 0 }

    for (c in s) {
        while (true) {
            val nTop = stack.lastOrNull()
            val topCount = count[nTop] ?: 0

            // 비어있을 경우 스택에 추가 후 방문 표시
            if (nTop == null) {
                stack.add(c)
                visit[c.index] = 1
                break
            }

            // 현재 문자가 이미 방문되었을 경우 스킵
            if (visit[c.index] == 1) break

            // 마지막 문자가 중복으로 등장하며, 현재 문자보다 사전순으로 뒤에 있을 경우
            // 제거하며 방문처리 초기화
            if (topCount > 0 && nTop > c) {
                stack.removeLast().let {
                    visit[it.index] = 0
                }
                continue
            }

            // 방문되지 않은 문자의 경우 스택에 추가하며 방문처리
            if (visit[c.index] == 0) {
                stack.add(c)
                visit[c.index] = 1
            }
            break
        }
        count[c] = count.getOrDefault(c, 0) - 1
    }

    return stack.joinToString("")
}

private fun String.countEachElement(): HashMap<Char, Int> {
    val r = hashMapOf<Char, Int>()

    for (c in this) {
        r[c] = r.getOrDefault(c, 0) + 1
    }

    return r
}

// https://leetcode.com/problems/remove-duplicate-letters/description/