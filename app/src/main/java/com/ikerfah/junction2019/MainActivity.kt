package com.ikerfah.junction2019

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ikerfah.junction2019.databinding.ActivityMainBinding
import com.ikerfah.junction2019.home.HomeFragment
import com.ikerfah.junction2019.kitchen.MyKitchenFragment
import com.ikerfah.junction2019.recieps.RecipeFragment
import com.ikerfah.junction2019.shopping.ShoppingFragment


class MainActivity : AppCompatActivity() {

    private val SCAN_CODE = 123
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var fm: FragmentManager
    private lateinit var active: Fragment
    private lateinit var homeFragment: Fragment
    private lateinit var recipeFragment: Fragment
    private lateinit var myKitchenFragment: Fragment
    private lateinit var shoppingFragment: Fragment

    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        homeFragment = HomeFragment()
        myKitchenFragment = MyKitchenFragment()
        shoppingFragment = ShoppingFragment()
        recipeFragment = RecipeFragment()
        active = homeFragment
        fm = supportFragmentManager

        fm.beginTransaction().add(R.id.main_fragment_container, recipeFragment, "4")
            .hide(recipeFragment).commit()
        fm.beginTransaction().add(R.id.main_fragment_container, shoppingFragment, "3")
            .hide(shoppingFragment).commit()
        fm.beginTransaction().add(R.id.main_fragment_container, myKitchenFragment, "2")
            .hide(myKitchenFragment).commit()
        fm.beginTransaction().add(R.id.main_fragment_container, homeFragment, "1").commit()
        mBinding.btnAdd.setOnClickListener {

            startActivity(Intent(this, ScanActivity::class.java))
//            startActivity(Intent(this, SubmitDataActivity::class.java))

        }

        mBinding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        setToolbarTitle(Constants.HOME_ID)



        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        mainViewModel.getMissedProduct().observe(this, Observer {

        })



    }

//    // Get the results:
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//
//        if (resultCode == SCAN_CODE) {
//            if (requestCode != Activity.RESULT_OK) {
//                Toast.makeText(this, "Scanned: ", Toast.LENGTH_LONG).show()
//            } else {
//                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data)
//        }
//    }

    private val mOnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {

            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.menu -> {
                        fm.beginTransaction().hide(active).show(homeFragment).commit()
                        active = homeFragment
                        setToolbarTitle(Constants.HOME_ID)
                        return true
                    }

                    R.id.recipies -> {
                        fm.beginTransaction().hide(active).show(recipeFragment).commit()
                        active = recipeFragment
                        setToolbarTitle(Constants.RECIPE_ID)
                        return true
                    }

                    R.id.shopping -> {
                        fm.beginTransaction().hide(active).show(shoppingFragment).commit()
                        active = shoppingFragment
                        setToolbarTitle(Constants.SHOPPING_ID)
                        return true
                    }

                    R.id.kitchen -> {
                        fm.beginTransaction().hide(active).show(myKitchenFragment).commit()
                        active = myKitchenFragment
                        setToolbarTitle(Constants.MY_CHICKEN_ID)
                        return true
                    }
                }
                return false
            }
        }

    fun setToolbarTitle(id: Int) {
        mBinding.toolbar.title = Constants.getTitle(id)
        mBinding.executePendingBindings()
    }

}
