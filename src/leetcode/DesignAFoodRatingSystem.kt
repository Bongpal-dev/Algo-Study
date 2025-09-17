package leetcode

import java.util.TreeSet

fun main() {
    val fr = FoodRatings(
        arrayOf("kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"),
        arrayOf("korean", "japanese", "japanese", "greek", "japanese", "korean"),
        intArrayOf(9, 12, 8, 15, 14, 7),
    )

    val cmd = listOf(
        "FoodRatings",
        "highestRated",
        "highestRated",
        "changeRating",
        "highestRated",
        "changeRating",
        "highestRated"
    )
    val param = listOf(
        listOf(""),
        listOf("korean"),
        listOf("japanese"),
        listOf("sushi", 16),
        listOf("japanese"),
        listOf("ramen", 16),
        listOf("japanese")
    )

    println(
        cmd.mapIndexed { i, v ->
            when (v) {
                "FoodRatings" -> "null"
                "changeRating" -> {
                    fr.changeRating(param[i][0].toString(), param[i][1].toString().toInt())
                    "null"
                }

                else -> {
                    fr.highestRated(param[i][0].toString())
                }
            }
        }
    )
}

private class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {
    private val ftc = hashMapOf<String, String>()
    private val ftr = hashMapOf<String, Int>()
    private val ctfs = hashMapOf<String, TreeSet<FoodInfo>>()

    init {
        foods.forEachIndexed { i, f ->
            val c = cuisines[i]
            val r = ratings[i]

            ftc[f] = c
            ftr[f] = r
            ctfs.getOrPut(c) {
                TreeSet(
                    compareByDescending<FoodInfo> { it.rating }
                        .thenBy { it.food }
                )
            }.add(FoodInfo(f, r))
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val c = ftc[food] ?: ""
        val pr = ftr[food] ?: 0

        ctfs[c]?.remove(FoodInfo(food, pr))
        ftr[food] = newRating
        ctfs[c]?.add(FoodInfo(food, newRating))
    }

    fun highestRated(cuisine: String): String {
        return ctfs[cuisine]?.first()?.food ?: ""
    }
}

private data class FoodInfo(
    val food: String = "",
    val rating: Int = 0
)

// https://leetcode.com/problems/design-a-food-rating-system/description