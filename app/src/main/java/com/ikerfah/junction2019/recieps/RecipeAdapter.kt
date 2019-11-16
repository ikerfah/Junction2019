package com.ikerfah.junction2019.recieps

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ikerfah.junction2019.Meal
import com.ikerfah.junction2019.databinding.ItemMealBinding

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private var mMeals = arrayListOf<Meal>()

    constructor(mMeals: ArrayList<Meal>) : super() {
        this.mMeals = mMeals
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

        return ViewHolder(
            ItemMealBinding.inflate(
                layoutInflater
            )
        )
    }

    override fun getItemCount(): Int {
        return mMeals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var meal: Meal = mMeals[position]

        (holder as ViewHolder).bind(meal)

    }



    class ViewHolder : RecyclerView.ViewHolder {

        private val mBinding: ItemMealBinding

        constructor(binding: ItemMealBinding) : super(binding.root) {
            mBinding = binding
        }

        fun bind(meal: Meal) {
            mBinding.meal = meal
            mBinding.executePendingBindings()
        }
    }


}