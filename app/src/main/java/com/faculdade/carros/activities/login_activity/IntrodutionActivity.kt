package com.faculdade.carros.activities.login_activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.faculdade.carros.R
import com.faculdade.carros.activities.register_activity.RegisterActivity

class IntrodutionActivity : AppCompatActivity() {
    private val buttonLogin by lazy { findViewById<View>(R.id.button_login) }
    private val buttonRegister by lazy { findViewById<View>(R.id.button_register) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        buttonRegister.setOnClickListener { RegisterActivity.start(this) }
       // buttonLogin.setOnClickListener { LoginActivity.start(this) }

    }
}