package com.faculdade.carros.activities.main_activity

import com.faculdade.carros.R

object CarFactory {

    @JvmStatic
    fun getListDefault() = mutableListOf(
        CarEntity("Civic", "Ano 2016", "Modelo: Civic 2.0","Cor: Prata", R.drawable.civic),
        CarEntity("Range Rover", "Ano 2014", "Modelo: Range Rover 3.0","Cor: Branco", R.drawable.xcar),
        CarEntity("Mustang", "Ano: 2010", "Modelo: Shelby GT500 660cv", "Cor: Preto", R.drawable.mustang),
        CarEntity("BMW", "Ano: 2017", "Modelo: M760Li 6.6 V12 610cv", "Cor: Vermelho Ímola", R.drawable.bmw)

    )
}
