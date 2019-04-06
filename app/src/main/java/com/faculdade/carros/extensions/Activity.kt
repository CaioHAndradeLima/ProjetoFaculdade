package com.faculdade.carros.extensions

import android.app.Activity
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.faculdade.carros.R


fun Activity.openSnackbar(text : String) {
    Snackbar.make(findViewById(R.id.container),text, Snackbar.LENGTH_LONG).show()
}

fun AppCompatActivity.configureActionBar() {
    supportActionBar?.let {
        it.setDisplayHomeAsUpEnabled(true)
        it.setHomeButtonEnabled(true)
        it.setDisplayShowHomeEnabled(true)
    }
}

abstract class AppCompatActivityBack : AppCompatActivity() {
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}