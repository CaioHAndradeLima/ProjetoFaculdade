package com.faculdade.carros.activities.main_activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.faculdade.carros.R

class MainActivity : AppCompatActivity() {

    companion object {
        fun start(context : Context) = context.startActivity(Intent(context, MainActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
