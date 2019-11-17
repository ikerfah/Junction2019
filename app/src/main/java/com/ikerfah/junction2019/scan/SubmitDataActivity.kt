package com.ikerfah.junction2019.scan

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ikerfah.junction2019.R
import com.ikerfah.junction2019.databinding.ActivitySubmitDataBinding
import com.ikerfah.junction2019.retro.Ressource


class SubmitDataActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivitySubmitDataBinding
    private lateinit var mViewModel: ScanViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_submit_data
        )

        mViewModel = ViewModelProviders.of(this).get(ScanViewModel::class.java)
        val mProgress = findViewById<ProgressBar>(R.id.circularProgressbar) as ProgressBar

        mProgress.progress = 0   // Main Progress
        mProgress.secondaryProgress = 100 // Secondary Progress
        mProgress.max = 100 // Maximum Progress
        mProgress.progress = 20   // Main Progress
        var pStatus = 0
        showLoading()


        Thread(Runnable {
            while (pStatus < 50) {
                pStatus += 1

                runOnUiThread {

                    mProgress.progress = pStatus
                    mBinding.textProgress.text = "$pStatus%"
                }
                try {
                    // Sleep for 200 milliseconds.
                    // Just to display the progress slowly
                    Thread.sleep(20) //thread will take approx 1.5 seconds to finish
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }


        }).start()

        Handler().postDelayed({
            mViewModel.addRecipe(intent.getStringExtra("qrcode")!!).observe(this, Observer {

                if (it.state == Ressource.SUCCES) {
                    runOnUiThread {
                        pStatus = 100
                        mProgress.progress = pStatus
                        mBinding.textProgress.text = "$pStatus%"
                    }
                    hideLoading()
                }

            })
        },3000)



        mBinding.btnReturn.setOnClickListener {
            finish()
        }


    }

    private fun showLoading() {
        runOnUiThread {

            mBinding.containerProgress.visibility = View.VISIBLE
            mBinding.textTitle.text = "WAIT A SECOND…"
            mBinding.mainContainer.setBackgroundColor(Color.WHITE)
            mBinding.containerSucces.visibility = View.GONE
            mBinding.textTitle.setTextColor(Color.parseColor("#444444"))
            mBinding.btnReturn.visibility = View.GONE
        }
    }

    private fun hideLoading() {
        runOnUiThread {

            mBinding.containerProgress.visibility = View.GONE
            mBinding.textTitle.text = "Your products have been \n" +
                    "added successfully"
            mBinding.mainContainer.setBackgroundColor(Color.parseColor("#01b091"))
            mBinding.containerSucces.visibility = View.VISIBLE
            mBinding.textTitle.setTextColor(Color.parseColor("#ffffff"))
            mBinding.btnReturn.visibility = View.VISIBLE
        }
    }
}
