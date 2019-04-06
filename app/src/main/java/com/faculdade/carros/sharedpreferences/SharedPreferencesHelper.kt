package com.faculdade.carros.sharedpreferences

import android.content.Context.MODE_PRIVATE
import android.app.Activity
import android.content.SharedPreferences

object SharedPreferencesHelper {

    private const val PREFERENCES_KEY = "PREFERENCES_KEY"

    private const val ID_USER_LOGGED_KEY = "ID_USER_LOGGED"

    private fun getInstance(activity: Activity): SharedPreferences {
        return activity
            .getSharedPreferences(PREFERENCES_KEY, MODE_PRIVATE)
    }

    fun getIdOfUserLogged(activity: Activity): Long {
        return getInstance(activity)
            .getLong(ID_USER_LOGGED_KEY, 0)
    }

    fun setIdUserLogged(activity: Activity, id : Long) {
        getInstance(activity)
            .edit()
            .putLong(ID_USER_LOGGED_KEY, id)
            .apply()
    }

}
