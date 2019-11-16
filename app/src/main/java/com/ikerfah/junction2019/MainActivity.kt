package com.ikerfah.junction2019

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ikerfah.junction2019.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var adapter = MealAdapter(
            arrayListOf(
                Meal("meal 1", "8/8 ing", "24 min", "Ready to tyab", "Healthy"),
                Meal("meal 2", "8/8 ing", "24 min", "Not to tyab", "Not Healthy"),
                Meal("meal 3", "8/8 ing", "24 min", "Ready to tyab", "Not  Healthy"),
                Meal("meal 4", "8/8 ing", "10 min", "Not to tyab", "Not  Healthy"),
                Meal("meal 5", "8/8 ing", "29 min", "Ready to tyab", "Healthy"),
                Meal("meal 6", "8/8 ing", "20 min", "Not to tyab", "Healthy"),
                Meal("meal 7", "8/8 ing", "5 min", "Ready to tyab", "Not Healthy"),
                Meal("meal 8", "8/8 ing", "64 min", "Ready to tyab", "Healthy")
            )
        )

        mBinding.recycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mBinding.recycler.adapter = adapter

        mBinding.recycler.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                with(outRect) {
                    bottom = 10
                }
            }
        })


    }
}
