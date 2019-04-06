package com.faculdade.carros.activities.login_activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.faculdade.carros.R
import com.faculdade.carros.activities.main_activity.MainActivity
import com.faculdade.carros.extensions.AppCompatActivityBack
import com.faculdade.carros.extensions.configureActionBar
import com.faculdade.carros.extensions.openSnackbar
import com.faculdade.carros.models.User
import com.faculdade.carros.sharedpreferences.SharedPreferencesHelper
import com.orm.SugarRecord
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivityBack() {
    companion object {
        @JvmStatic
        fun start(context: Context) = context.startActivity(Intent(context, LoginActivity::class.java))
    }

    private val buttonLogin by lazy { button_login }
    private val edtEmail by lazy { edittext_email }
    private val edtPassword by lazy { edittext_password }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        configureActionBar()

        buttonLogin.setOnClickListener {
            SugarRecord
                .findAll(User::class.java)
                .forEach {
                    if (it.email == toString(edtEmail) && it.password == toString(edtPassword)) {
                        SharedPreferencesHelper.setIdUserLogged(this, it.id)
                        MainActivity.start(this)
                        return@setOnClickListener
                    }
                }

            openSnackbar(getString(R.string.user_not_found))
        }
    }

    private fun toString(editText: EditText): String {
        return editText.text.toString()
    }
}