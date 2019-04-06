package com.faculdade.carros.extensions

import android.app.Activity
import android.support.design.widget.Snackbar
import com.faculdade.carros.R


fun Activity.openSnackbar(text : String) {
    Snackbar.make(findViewById(R.id.container),text, Snackbar.LENGTH_LONG).show()
}