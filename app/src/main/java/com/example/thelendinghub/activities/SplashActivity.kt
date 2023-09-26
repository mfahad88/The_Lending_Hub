package com.example.thelendinghub.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.thelendinghub.R

class SplashActivity : BaseActivity() {
    private val SPLASH_DURATION:Long = 5000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        },SPLASH_DURATION)
    }
}