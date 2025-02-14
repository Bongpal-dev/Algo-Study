package graph

fun main() {
    println(letterCombinations("23"))
    println(letterCombinations(""))
    println(letterCombinations("2"))
}

private fun letterCombinations(digits: String): List<String> {
    if (digits.isBlank()) return emptyList()

    val answer = mutableListOf<String>()
    val letters = hashMapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz",
    )

    findCombinations(digits, 0, "", answer, letters)

    return answer
}

private fun findCombinations(
    digits: String,
    current: Int,
    prev: String,
    answer: MutableList<String>,
    letters: HashMap<Char, String>,
) {
    val b = digits[current]

    for (l in letters[b] ?: "") {
        val combination = prev + l

        if (current == digits.lastIndex) {
            answer += combination
        } else {
            findCombinations(digits, current + 1, combination, answer, letters)
        }
    }
}

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/