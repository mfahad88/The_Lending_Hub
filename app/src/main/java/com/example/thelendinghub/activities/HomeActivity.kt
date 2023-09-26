package com.example.thelendinghub.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.example.thelendinghub.R

import com.example.thelendinghub.custom.Utils


class HomeActivity : BaseActivity() {
    private lateinit var buttonRegister:AppCompatButton
    private lateinit var buttonLogin:AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViews()
        Utils.getScreenDensity(this)
        buttonRegister.setOnClickListener { v->
            startActivity(Intent(v.context,OnBoardActivity::class.java))
        }
    }

    private fun initViews() {
        buttonRegister=findViewById(R.id.buttonRegister)
        buttonLogin=findViewById(R.id.buttonLogin)

    }
}