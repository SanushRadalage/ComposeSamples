package com.example.assignment.presentation.ui

import android.content.Intent
import android.os.Bundle
import com.example.assignment.R
import com.example.assignment.presentation.base.BaseActivity

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}