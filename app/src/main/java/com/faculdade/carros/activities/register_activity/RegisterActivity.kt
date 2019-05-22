package com.faculdade.carros.activities.register_activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
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
import io.reactivex.Observable

class RegisterActivity : AppCompatActivityBack() {
    private val buttonRegister by lazy { findViewById<View>(R.id.button_register) }
    private val edtName by lazy { findViewById<EditText>(R.id.edittext_name) }
    private val edtEmail by lazy { findViewById<EditText>(R.id.edittext_email) }
    private val edtPassword by lazy { findViewById<EditText>(R.id.edittext_password) }
    private val edtDocument by lazy { findViewById<EditText>(R.id.edittext_document) }

    companion object {
        @JvmStatic
        fun start(context: Context) = context.startActivity(Intent(context, RegisterActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        configureActionBar()

        buttonRegister.setOnClickListener {
            Observable
                .just(
                    User(
                        toString(edtName),
                        toString(edtEmail),
                        toString(edtPassword),
                        toString(edtDocument)
                    )
                ).filter { validate(it) }
                .filter {
                    SugarRecord.findAll(User::class.java).forEach { user ->
                        if(it.email == user.email ||
                                it.document == user.document) {
                            openSnackbar(getString(R.string.user_already_exists))
                            return@filter false
                        }
                    }
                    true
                }
                .doOnNext { it.save() }
                .doOnNext { SharedPreferencesHelper.setIdUserLogged(this, it.id) }
                .doOnNext { MainActivity.start(this) }
                .subscribe()
        }
    }

    private fun validate(it: User): Boolean {
        if (ValidateHelper.isValid(it))
            return true

        openSnackbar(getString(R.string.not_valid))
        return false
    }

    private fun toString(editText: EditText): String {
        return editText.text.toString()
    }

}