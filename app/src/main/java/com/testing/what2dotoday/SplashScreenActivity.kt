package com.testing.what2dotoday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {
    private val splashTime = 2000L
    private lateinit var myhandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        myhandler = Handler()
        myhandler.postDelayed({
            //goToMainActivity()
            goToTestActivity()
        },splashTime)
    }

    private fun goToMainActivity() {
        val mainActivityIntent = Intent(applicationContext, MainActivity::class.java)
        startActivity(mainActivityIntent)
        finish()
    }
    private fun goToTestActivity() {
        val testActivityIntent = Intent(applicationContext, Test::class.java)
        startActivity(testActivityIntent)
        finish()
    }
}
