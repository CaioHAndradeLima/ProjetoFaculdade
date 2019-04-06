package com.faculdade.carros.activities.register_activity

import com.faculdade.carros.models.User

object ValidateHelper {
    private const val SIZE_CPF = 11

    fun isValid(userView: User): Boolean {
        return userView.document.toString().length == SIZE_CPF &&
                userView.email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(userView.email).matches() &&
                userView.name.length > 3 &&
                userView.password.length > 4
    }

}
