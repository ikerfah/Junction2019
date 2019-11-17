package com.ikerfah.junction2019

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.viksaa.sssplash.lib.activity.AwesomeSplash
import com.daimajia.androidanimations.library.Techniques
import com.viksaa.sssplash.lib.cnst.Flags.REVEAL_BOTTOM
import com.viksaa.sssplash.lib.cnst.Flags.REVEAL_RIGHT
import android.R.id.primary
import com.viksaa.sssplash.lib.cnst.Flags
import com.viksaa.sssplash.lib.model.ConfigSplash



class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },3500)
    }

    /*override fun initSplash(configSplash: ConfigSplash) {

        /* you don't have to override every property */

        //Customize Circular Reveal
        configSplash.backgroundColor = R.color.healthyColor //any color you want form colors.xml
        configSplash.animCircularRevealDuration = 2000 //int ms
        configSplash.revealFlagX = Flags.REVEAL_RIGHT  //or Flags.REVEAL_LEFT
        configSplash.revealFlagY = Flags.REVEAL_BOTTOM //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        configSplash.logoSplash = R.mipmap.ic_launcher //or any other drawable
        configSplash.animLogoSplashDuration = 2000 //int ms
        configSplash.animLogoSplashTechnique =
            Techniques.Bounce //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)


        //Customize Path
        configSplash.pathSplash = Constants.DROID_LOGO //set path String
        configSplash.originalHeight = 400 //in relation to your svg (path) resource
        configSplash.originalWidth = 400 //in relation to your svg (path) resource
        configSplash.animPathStrokeDrawingDuration = 3000
        configSplash.pathSplashStrokeSize = 3 //I advise value be <5
//        configSplash.pathSplashStrokeColor = R.color.accent //any color you want form colors.xml
        configSplash.animPathFillingDuration = 3000
//        configSplash.pathSplashFillColor = R.color.Wheat //path object filling color


        //Customize Title
        configSplash.titleSplash = "WeSave"
        configSplash.titleTextColor = R.color.white
        configSplash.titleTextSize = 30f //float value
        configSplash.animTitleDuration = 3000
        configSplash.animTitleTechnique = Techniques.FlipInX
        configSplash.titleFont =
            "fonts/myfont.ttf" //provide string to your font located in assets/fonts/

    }

    override fun animationsFinished() {

        //transit to another activity here
        //or do whatever you want
    }*/
}
