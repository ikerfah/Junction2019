package com.ikerfah.junction2019

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ikerfah.junction2019.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var adapter = MealAdapter(
            arrayListOf(
                Meal("meal 1"),
                Meal("meal 2"),
                Meal("meal 3"),
                Meal("meal 4"),
                Meal("meal 5"),
                Meal("meal 6"),
                Meal("meal 7"),
                Meal("meal 8")
            )
        )

        mBinding.recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
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
