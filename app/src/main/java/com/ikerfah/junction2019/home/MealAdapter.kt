package com.ikerfah.junction2019.home

import android.graphics.Color
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ikerfah.junction2019.Meal
import com.ikerfah.junction2019.databinding.ItemHeaderBinding
import com.ikerfah.junction2019.databinding.ItemMealBinding

class MealAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private var mMeals = arrayListOf<Meal>()

    constructor(mMeals: ArrayList<Meal>) : super() {
        this.mMeals = mMeals
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        if (viewType == TYPE_HEADER) {
            return ViewHolderHeader(
                ItemHeaderBinding.inflate(
                    layoutInflater
                )
            )
        } else {

            return ViewHolderProduct(
                ItemMealBinding.inflate(
                    layoutInflater
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return mMeals.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        var meal: Meal = mMeals[position]

        if (holder.itemViewType == TYPE_HEADER) {
            (holder as ViewHolderHeader).bind(
                "ikerfah"
            )
        } else {
            (holder as ViewHolderProduct).bind(meal)

        }
    }


    private val TYPE_HEADER = 1
    private val TYPE_PRODUCT = 2
    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return TYPE_HEADER
        }

        return TYPE_PRODUCT
    }

    class ViewHolderHeader : RecyclerView.ViewHolder {

        private val mBinding: ItemHeaderBinding

        constructor(binding: ItemHeaderBinding) : super(binding.root) {
            mBinding = binding
        }

        fun bind(name: String) {

            val styledText = "Hi <font color='#01b091'>$name</font><br>Here are some ideas for<br>your next meal"
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                // FROM_HTML_MODE_LEGACY is the behaviour that was used for versions below android N
                // we are using this flag to give a consistent behaviour
                mBinding.textWlc.setText(
                    Html.fromHtml(styledText, Html.FROM_HTML_MODE_LEGACY),
                    TextView.BufferType.SPANNABLE
                )
            } else {
                mBinding.textWlc.setText(
                    Html.fromHtml(styledText),
                    TextView.BufferType.SPANNABLE
                )
            }
            mBinding.executePendingBindings()
        }
    }

    class ViewHolderProduct : RecyclerView.ViewHolder {

        private val mBinding: ItemMealBinding

        constructor(binding: ItemMealBinding) : super(binding.root) {
            mBinding = binding
        }

        fun bind(meal: Meal) {
            mBinding.meal = meal

            if (meal.foodType.equals("Healthy", true)) {
                mBinding.textIsHealthy.setBackgroundColor(Color.parseColor("#01b091"))
            } else {
                mBinding.textIsHealthy.setBackgroundColor(Color.parseColor("#ff5a5e"))
            }

            if (meal.state.equals("Ready to cock", true)) {
                mBinding.textMealState.setTextColor(Color.parseColor("#01b091"))
            } else if (meal.state.equals("You need some ingredients", true)) {
                mBinding.textMealState.setTextColor(Color.parseColor("#ffc82f"))
            }else {
                mBinding.textMealState.setTextColor(Color.parseColor("#ff5a5e"))
            }


            mBinding.executePendingBindings()
        }
    }


}