package com.tanriverdi.bmicalculatorapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //After adding a 1.5 second delay, you will go to the Main page
        // In the manifest section ,, we were added to this activity with intent filter so that this activity will rub first.

        Handler().postDelayed({
            val intent = Intent ( this@SplashScreen,MainActivity::class.java)
            startActivity(intent)
            finish()

        },1500)


    }
}