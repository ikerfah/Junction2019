package com.ikerfah.junction2019

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ikerfah.junction2019.databinding.ActivityMainBinding
import com.ikerfah.junction2019.home.HomeFragment
import com.ikerfah.junction2019.kitchen.MyKitchenFragment


class MainActivity : AppCompatActivity() {

    private val SCAN_CODE = 123
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var fm: FragmentManager
    private lateinit var active: Fragment
    private lateinit var homeFragment: Fragment
    private lateinit var myKitchenFragment: Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        homeFragment = HomeFragment()
        myKitchenFragment = MyKitchenFragment()
        active = homeFragment
        fm = supportFragmentManager

//        fm.beginTransaction().add(R.id.main_fragment_container, fragment3, "3").hide(fragment3).commit()
        fm.beginTransaction().add(R.id.main_fragment_container, myKitchenFragment, "2").hide(myKitchenFragment).commit()
        fm.beginTransaction().add(R.id.main_fragment_container, homeFragment, "1").commit()
        mBinding.btnAdd.setOnClickListener {
            //            val integrator = IntentIntegrator(this)
//            integrator.setOrientationLocked(false)
//
//            integrator.captureActivity = ScanActivity::class.java
//            integrator.initiateScan()


            startActivity(Intent(this, ScanActivity::class.java))
//            startActivity(Intent(this, SubmitDataActivity::class.java))
//            IntentIntegrator(this).setOrientationLocked(false)
//                .setCaptureActivity(ScanActivity::class.java).initiateScan()

        }

        mBinding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


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
                when (item.getItemId()) {
                    R.id.home -> {
                        fm.beginTransaction().hide(active).show(homeFragment).commit()
                        active = homeFragment
                        return true
                    }

                    R.id.recipies -> {

                        return true
                    }

                    R.id.shopping -> {
                        return true
                    }

                    R.id.kitchen -> {
                        fm.beginTransaction().hide(active).show(myKitchenFragment).commit()
                        active = myKitchenFragment
                        return true
                    }
                }
                return false
            }
        }
}
