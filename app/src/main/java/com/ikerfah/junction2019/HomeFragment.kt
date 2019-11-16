package com.ikerfah.junction2019


import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ikerfah.junction2019.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private lateinit var mBinding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentHomeBinding.inflate(inflater,container,false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
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
