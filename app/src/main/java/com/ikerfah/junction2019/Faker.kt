package com.ikerfah.junction2019

import com.ikerfah.junction2019.kitchen.MyChickenChild
import com.ikerfah.junction2019.kitchen.MyChickenGroup


class Faker {

    companion object{
        fun getData(): HashMap<String, List<MyChickenChild>> {
            val expandableListDetail = HashMap<String, List<MyChickenChild>>()

            val cricket = ArrayList<MyChickenChild>()
            cricket.add(MyChickenChild("India","5"))
            cricket.add(MyChickenChild("Pakistan","12"))
            cricket.add(MyChickenChild("Australia","1"))
            cricket.add(MyChickenChild("England","2"))
            cricket.add(MyChickenChild("South Africa","5"))

            val football = ArrayList<MyChickenChild>()
            football.add(MyChickenChild("Brazil","2"))
            football.add(MyChickenChild("Italy","5"))

            val basketball = ArrayList<MyChickenChild>()
            basketball.add(MyChickenChild("United States","2"))
            basketball.add(MyChickenChild("Spain","4"))
              basketball.add(MyChickenChild("Russia","7"))

            expandableListDetail["Fruits and Vegetables"] = cricket
            expandableListDetail["Poultry and Meat"] = football
            expandableListDetail["Milk Products"] = basketball
            return expandableListDetail
        }
    }
}