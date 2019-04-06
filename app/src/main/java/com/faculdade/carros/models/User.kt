package com.faculdade.carros.models

import com.orm.SugarRecord

data class User(
    val name : String = "",
    val email : String = "",
    val password : String = "",
    val document : String = ""
) : SugarRecord()