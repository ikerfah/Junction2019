package com.ikerfah.junction2019

import android.app.Activity
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ikerfah.junction2019.databinding.ActivityMainBinding
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.annotation.NonNull
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


class MainActivity : AppCompatActivity() {

    private val SCAN_CODE = 123
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var fm : FragmentManager
    private lateinit var active : Fragment
    private lateinit var fragment1 : Fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        fragment1 = HomeFragment()
        active = fragment1
        val fm = supportFragmentManager

//        fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit();
//        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.main_fragment_container,fragment1, "1").commit()
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
                        fm.beginTransaction().hide(active).show(fragment1).commit()
                        active = fragment1
                        return true
                    }

                    R.id.recipies -> {

                        return true
                    }

                    R.id.shopping -> {
                        return true
                    }

                    R.id.kitchen -> {
                        return true
                    }
                }
                return false
            }
        }
}
