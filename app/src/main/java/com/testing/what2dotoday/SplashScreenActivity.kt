package com.testing.what2dotoday

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.testing.what2dotoday.MainActivity
import com.testing.what2dotoday.Test
class SplashScreenActivity : AppCompatActivity() {
    private val splashTime = 2000L
    private lateinit var myhandler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        myhandler = Handler()
        myhandler.postDelayed({
            goToSignInActivity()
            //goToTestActivity()
        },splashTime)
    }

    private fun goToSignInActivity() {
        val signInActivityIntent = Intent(applicationContext, SignInActivity::class.java)
        startActivity(signInActivityIntent)
        finish()
    }
    private fun goToTestActivity() {
        val testActivityIntent = Intent(applicationContext, Test::class.java)
        startActivity(testActivityIntent)
        finish()
    }
}
