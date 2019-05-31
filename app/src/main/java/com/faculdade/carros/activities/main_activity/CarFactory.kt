package com.faculdade.carros.activities.main_activity

import com.faculdade.carros.R

object CarFactory {


    @JvmStatic
    fun getListDefault() = mutableListOf(
        CarEntity("Range Rover", "Ano 2014", "Modelo: Range Rover 3.0","R$250,00 - Diária", R.drawable.xcar),
        CarEntity("Mustang", "Ano: 2010", "Modelo: Shelby GT500 660cv", "R$400,00 - Diária", R.drawable.mustang),
        CarEntity("BMW", "Ano: 2017", "Modelo: M760Li 6.6 V12 610cv", "R$250,00 - Diária", R.drawable.bmw),
        CarEntity("Corolla", "Ano: 2020", "Novo Corolla 2.0", "250,00 - Diária", R.drawable.newcorolla),
        CarEntity("Civic", "Ano: 2016", "Modelo: Civic 2.0","R$150,00 - Diária", R.drawable.civic)


    )
}
