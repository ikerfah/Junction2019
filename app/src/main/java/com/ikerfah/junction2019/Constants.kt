package com.ikerfah.junction2019

class Constants {

    companion object {
        val HOME_ID = 1
        val RECIPE_ID = 2
        val SHOPPING_ID = 3
        val MY_CHICKEN_ID = 4

        val titles = hashMapOf<Int, String>(
            HOME_ID to "Home",
            RECIPE_ID to "Recipes",
            SHOPPING_ID to "Shopping List",
            MY_CHICKEN_ID to "Your Kitchen"
        )

        fun getTitle(id: Int): String {
            return titles[id]!!
        }
    }
}