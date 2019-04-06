package com.faculdade.carros.activities.main_activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.faculdade.carros.R

class MainActivity : AppCompatActivity() {

    companion object {
        fun start(context : Context) {
            val it = Intent(context, MainActivity::class.java)
            it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            context.startActivity(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
