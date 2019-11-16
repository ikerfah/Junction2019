package com.ikerfah.junction2019

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ikerfah.junction2019.databinding.ItemMealBinding

class MealAdapter : RecyclerView.Adapter<MealAdapter.ViewHolder> {

    private var mMeals = arrayListOf<Meal>()

    constructor(mMeals: ArrayList<Meal>) : super() {
        this.mMeals = mMeals
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater= LayoutInflater.from(parent.context)
        val mealBinding : ItemMealBinding  = ItemMealBinding.inflate(layoutInflater)
        return ViewHolder(mealBinding)
    }

    override fun getItemCount(): Int {
        return mMeals.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var meal: Meal = mMeals[position]
        holder.bind(meal)
    }


    class ViewHolder : RecyclerView.ViewHolder {

        private val mBinding:ItemMealBinding
        constructor(binding:ItemMealBinding) : super(binding.root) {
            mBinding = binding
        }

        fun bind(meal: Meal) {
            mBinding.meal = meal
            mBinding.executePendingBindings()
        }
    }


}