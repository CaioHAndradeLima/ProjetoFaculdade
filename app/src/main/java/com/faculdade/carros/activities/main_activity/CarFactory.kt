package com.faculdade.carros.activities.main_activity

import com.faculdade.carros.R

object CarFactory {

    @JvmStatic
    fun getListDefault() = mutableListOf(
        CarEntity("Civic", "Ano 2016", "Modelo Civic 2.0", R.drawable.civic),
        CarEntity("X car", "Ano 2014", "Modelo xCar 3.0", R.drawable.xcar)
    )
}
